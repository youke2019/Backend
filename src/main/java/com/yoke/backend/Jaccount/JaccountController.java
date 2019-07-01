package com.yoke.backend.Jaccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
    public ResponseEntity<String> getInfo(@RequestParam("code")String code) {
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
        return responseEntity;
    }
}
