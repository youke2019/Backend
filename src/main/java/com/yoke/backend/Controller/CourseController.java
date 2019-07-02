package com.yoke.backend.Controller;


import com.alibaba.fastjson.JSON;
import com.yoke.backend.Entity.CourseInfo;
import com.yoke.backend.Entity.RawCourseInfo;
import com.yoke.backend.Entity.RawCourseResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {

    @PostConstruct
    public void init(){ }


    private List<CourseInfo> parseRawCourseInfo(List<RawCourseInfo> rawCourseInfos){
        for(RawCourseInfo info : rawCourseInfos){

        }
        return null;
    }
    /**
     *
     * @param requestUrl
     * @param Cookie
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateCourseTable(String requestUrl ,String Cookie) throws IOException {
        String res = "";
        StringBuffer buffer = new StringBuffer();

        URL url = new URL(requestUrl.replace("\"",""));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        conn.setRequestProperty("accept", "*/*");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.setRequestProperty("user-agent",   "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
        conn.setRequestProperty("Cookie", Cookie);
        conn.setRequestProperty("Host","i.sjtu.edu.cn");
        OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream(),"UTF-8");
        osw.write("xnm=2018&_search=false&nd=1561987754238&queryModel.showCount=100&queryModel.currentPage=1&queryModel.sortName=&queryModel.sortOrder=asc");
        osw.flush(); //不flush 发生了bug，等下试试\n
        InputStream inputStream = conn.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream,"utf-8");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String str = null;
        while ((str = bufferedReader.readLine()) != null){
            buffer.append(str);
        }
        res = buffer.toString();
        RawCourseResponse response = JSON.parseObject(res,RawCourseResponse.class);
        List<CourseInfo> courseInfos = parseRawCourseInfo(response.getRawCourseInfo());

        return "yes";
    }

}

