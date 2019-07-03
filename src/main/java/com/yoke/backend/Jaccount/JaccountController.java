package com.yoke.backend.Jaccount;

import com.alibaba.fastjson.JSONObject;
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

    private String tokenUrl = "https://jaccount.sjtu.edu.cn/oauth2/token";
    private String profileApi = "https://api.sjtu.edu.cn/v1/me/profile";
    private String client_id = "EHuqrWEKvazXzTErwPmCX2m1";
    private String client_secret = "BA796DCE46F7832F7C4AE3D3DA912CB9703186BA9137D56B";
    private String grant_type = "authorization_code";

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public User login(@RequestParam("code")String code, HttpServletResponse response) {
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
        param.add("redirect_uri","http://10.0.2.2:8080/jaccount/login");

        // request for access token with http request
        HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(param,headers);
        responseEntity = restTemplate.postForEntity(tokenUrl,request,String.class);

        // use access token to get user profile with http request
        JSONObject responseJson = JSONObject.parseObject(responseEntity.getBody());
        String token = responseJson.getString("access_token");
        String url = profileApi
                +"?access_token="+token;
        responseEntity = restTemplate.getForEntity(url, String.class);

        // parse response
        User userinfo = new User();
        responseJson = JSONObject.parseObject(responseEntity.getBody());
        userinfo.setName(responseJson.getJSONArray("entities").getJSONObject(0).getString("name"));
        userinfo.setDepartment(responseJson.getJSONArray("entities").getJSONObject(0).getJSONObject("organize").getString("name"));
        userinfo.setMajor(responseJson.getJSONArray("entities").getJSONObject(0).getJSONArray("identities").getJSONObject(0).getJSONObject("major").getString("name"));
        try {
            String name = userinfo.getName();
            String department = userinfo.getDepartment();
            String major = userinfo.getMajor();
            String app_url = "yoke://?name="+name+"&department="+department+"&major="+major;
            response.sendRedirect(app_url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userinfo;
    }
}
