package com.yoke.backend.Controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONReader;
import com.yoke.backend.Entity.*;
import org.bson.json.JsonReader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.sound.midi.SysexMessage;
import java.io.*;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/course")
public class CourseController {

    @PostConstruct
    public void init(){ }

    /** no need anymore
    private ClassInfo getClass(List<ClassInfo> infos, String classname){
        for(ClassInfo info : infos){
            if(classname.equals(info.getClassname()))
                return info;
        }
        return null;
    }*/
    private void parseTeacher(String unparsed,ClassInfo info){
        if(unparsed == null){
            System.out.println("no teacher of this" + info.getCourse_id());
            return;
        }

        String[] strs = unparsed.split("\\|");
        info.setTeacher_id(strs[0]);
        info.setTeacher_name(strs[1]);
    }
    private void parseCourseTime(String unparsed,ClassSegment segment){
        if(unparsed.contains(",")) {
            System.out.println("false syntax:" + unparsed);
            return ;
        }
        int week = 0;
        switch (unparsed.charAt(2)){
            case '一': week = 1; break;
            case '二': week = 2; break;
            case '三': week = 3; break;
            case '四': week = 4; break;
            case '五': week = 5; break;
            case '六': week = 6; break;
            case '日': week = 7; break;
         }
         segment.setWeek(week);
       // System.out.println(unparsed);
        String[] strs = unparsed.split("第|-|节\\{|周|}");
        segment.setBegin_sec(Integer.valueOf(strs[1]));
        segment.setEnd_sec( Integer.valueOf(strs[2]));
        segment.setBegin_week(Integer.valueOf(strs[3]));
        if(strs.length == 4) segment.setEnd_week(Integer.valueOf(strs[3])); /** 表明只有一周上课*/
        else segment.setEnd_week(Integer.valueOf(strs[4]));
        if(strs.length == 6){                                               /** 表明是单双周的课*/
            Character ch = strs[5].charAt(1);
            if (ch == '单') segment.setOddOrEven('o');
            else segment.setOddOrEven('e');
        }else segment.setOddOrEven('b');

    }
    private void parseCourseArrangement(String unparsed, List<ClassSegment> segments){
        if(unparsed == null) {
            return ;
        }
        String[] strs = unparsed.split("\\|");
        for(String time : strs[0].split(";")){
            ClassSegment segment = new ClassSegment();
            parseCourseTime(time,segment);
            segments.add(segment);
        }
        if(strs.length == 1) {
            return;
        }
        String classrooms[] = strs[1].split(";");
        for (int i = 0;i < classrooms.length; i ++){
            segments.get(i).setClassroom(classrooms[i]);
        }
    }
    /** 无需parse了
     * private void parseTeachers(String unparsed,String teachers){
        teachers = "";
        for(String retval: unparsed.split(";")){
            String[] strs = retval.split("/");
            teachers += strs[1] + ";";
        }
    }*/
    public List<CourseInfo> parseRawCourseInfo(List<RawCourseInfo> rawCourseInfos){
        Map<String,CourseInfo> map = new HashMap<String,CourseInfo>();  /** course id => course info */
        for(RawCourseInfo info : rawCourseInfos){
            CourseInfo courseInfo;
            String courseID = info.getCourse_id();
            if(! map.containsKey(courseID)) { /* 不存在相关记录就创建新的。*/
                courseInfo = new CourseInfo();
                courseInfo.setCourse_id(courseID);
                courseInfo.setCourse_name(info.getCourse_name());
                courseInfo.setCourse_credits(info.getCredits());
                courseInfo.setGeneral(info.getGeneral_course().equals("是"));
                courseInfo.setGeneral_type(info.getGeneral_type());
                courseInfo.setClasses(new ArrayList<>());
            }else courseInfo = (CourseInfo) map.get(courseID);

            ClassInfo classInfo = new ClassInfo();
            classInfo.setCourse_id(courseID);
            classInfo.setClassname(info.getClass_name());
            parseTeacher(info.getTeacher(),classInfo);
            classInfo.setTeachers(info.getTeacher_info());
            classInfo.setCourse_participants(info.getChosen_number());
            classInfo.setClassSegments(new ArrayList<>());
            if(info.getCourse_time_unparsed() == null){System.out.println("No Course arrangement of this course: " + info.getCourse_id());}
            parseCourseArrangement(info.getCourse_time_unparsed(),classInfo.getClassSegments());
            for(ClassSegment segment: classInfo.getClassSegments())
                segment.setClassname(info.getClass_name());

            courseInfo.getClasses().add(classInfo);
            map.put(courseID,courseInfo);
        }
        ArrayList<CourseInfo> courseInfos = new ArrayList<>();
        for(CourseInfo info : map.values()){
            courseInfos.add(info);
        }
        return courseInfos;
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
        osw.write("xnm=2018&_search=false&nd=1561987754238&queryModel.showCount=7500&queryModel.currentPage=1&queryModel.sortName=&queryModel.sortOrder=asc");
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
        String jsonString = JSON.toJSONString(courseInfos);
        //System.out.println(response.getRawCourseInfo().size());
        //System.out.println(courseInfos.size());

        return jsonString;
    }

}

