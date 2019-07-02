package com.yoke.backend.Jaccount;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/jaccount")
public class JaccountController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void login() {
        String baseUrl = "https://jaccount.sjtu.edu.cn/oauth2/authorize";
        String client_id = "EHuqrWEKvazXzTErwPmCX2m1";
        String redirect_uri= "http://localhost:8080/jaccount/info";
        String url = baseUrl+"?client_id="+client_id+"&response_type=code&redirect_uri="+redirect_uri;
    }

    @ResponseBody
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public User getInfo(@RequestParam("code")String code) {
        System.out.println(code);
        MultiValueMap<String,String> param = new LinkedMultiValueMap<>();
        param.add("code",code);
        param.add("client_id","EHuqrWEKvazXzTErwPmCX2m1");
        param.add("client_secret","BA796DCE46F7832F7C4AE3D3DA912CB9703186BA9137D56B");
        param.add("grant_type","authorization_code");
        param.add("redirect_uri","http://localhost:8080/jaccount/info");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(param,headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("https://jaccount.sjtu.edu.cn/oauth2/token",request,String.class);
        System.out.println(responseEntity);

        JSONObject responseJson = JSONObject.parseObject(responseEntity.getBody());
        String token = responseJson.getString("access_token");
        responseEntity = restTemplate.getForEntity("https://api.sjtu.edu.cn/v1/me/profile?access_token="+token, String.class);

        responseJson = JSONObject.parseObject(responseEntity.getBody());
        System.out.println(responseJson.get("entities"));

        JSONArray array = JSONArray.parseArray(responseJson.get("entities").toString());
        JSONObject object = JSONObject.parseObject(array.get(0).toString());
        System.out.println(object);

        User userinfo = new User();
        userinfo.setName(object.getString("name"));
        userinfo.setDepartment(object.getJSONObject("organize").getString("name"));
        userinfo.setMajor(object.getJSONArray("identities").getJSONObject(0).getJSONObject("major").getString("name"));
        return userinfo;
    }
}
