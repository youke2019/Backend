package com.yoke.backend.Controller;

import com.alibaba.fastjson.JSONObject;
import com.yoke.backend.Entity.User.User;
import com.yoke.backend.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/jaccount")
public class JaccountController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserService userService;

    private String tokenUrl = "https://jaccount.sjtu.edu.cn/oauth2/token";
    private String profileApi = "https://api.sjtu.edu.cn/v1/me/profile";
    private String client_id = "k8vX4aeVqZc0VCP1rSaG";
    private String client_secret = "E0C775E0A140B98F4A083EA876F2FDD5629B38E9F8C7088A";
    private String grant_type = "authorization_code";
    private String base_url = "http://192.168.42.163:8000";

    /**
     * @api {get} /login
     * @apiDescription 用Oauth2的code进行user登陆
     * @apiName login
     * @apiGroup jaccount
     * @apiVersion 1.0.0
     * @apiParam {String} code
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam("code")String code, HttpServletResponse response) {
        ResponseEntity<String> responseEntity;

        // post header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");

        // post body
        MultiValueMap<String,String> param = new LinkedMultiValueMap<>();
        param.add("code",code);
        param.add("client_id",client_id);
        param.add("client_secret",client_secret);
        param.add("grant_type",grant_type);
        param.add("redirect_uri",base_url+"/jaccount/login");

        // request for access token with http request
        HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(param,headers);
        responseEntity = restTemplate.postForEntity(tokenUrl,request,String.class);

        // use access token to get user profile with http request
        JSONObject responseJson = JSONObject.parseObject(responseEntity.getBody());
        String token = responseJson.getString("access_token");
        System.out.println(token);
        try {
            String app_url = "yoke://login?access_token="+token;
            response.sendRedirect(app_url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirecting";
    }


    /**@api {get} /profile
     * @apiDescription 用Oauth2的access_token获取用户信息
     * @apiName getProfile
     * @apiGroup jaccount
     * @apiVersion 1.0.0
     *
     * @apiParam {String} token
     */
    @ResponseBody
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public User getProfile(@RequestParam("access_token")String token) {
        String url = profileApi
                +"?access_token="+token;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

        // parse response
        JSONObject responseJson = JSONObject.parseObject(responseEntity.getBody());
        String name = responseJson.getJSONArray("entities").getJSONObject(0).getString("name");
        String department = responseJson.getJSONArray("entities").getJSONObject(0).getJSONObject("organize").getString("name");

        String major = responseJson.getJSONArray("entities").getJSONObject(0).getJSONArray("identities").getJSONObject(0).getJSONObject("major").getString("name");
        String gender = responseJson.getJSONArray("entities").getJSONObject(0).getString("gender");
        String admission_date = responseJson.getJSONArray("entities").getJSONObject(0).getJSONArray("identities").getJSONObject(0).getString("admissionDate");
        String id = responseJson.getJSONArray("entities").getJSONObject(0).getString("id");

        // build response json
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setDepartment(department);
        user.setMajor(major);
        user.setAdmissionYear(Integer.parseInt(admission_date.substring(0, 4)));

        switch (gender) {
            case "male":
                user.setSex('M');
                break;
            case "female":
                user.setSex('F');
                break;
        }

        // save user data into database.
        User new_user = userService.generateUserIfNoUserLike(user);
        System.out.println(user.getNickname());
        System.out.println(new_user.getNickname());
        return new_user;
    }
}
