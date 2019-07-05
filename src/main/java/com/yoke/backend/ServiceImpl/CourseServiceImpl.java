package com.yoke.backend.ServiceImpl;

import com.alibaba.fastjson.JSON;
import com.yoke.backend.Dao.CourseDao;
import com.yoke.backend.Entity.Course.*;
import com.yoke.backend.Service.CourseService;
import com.yoke.backend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/3
 * @description:
 **/
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseDao courseDao;


    final private int receive_course_number_limit = 10000;
    final private int search_course_year = 2018;
    final private int search_course_semester = 3; //   1:3 ,   2:12,   夏季学期:16

    @Override
    public void GetCourseFromJWC(String url,String cookies) throws IOException {
        List<CourseInfo> courseInfoList = updateCourseTable(url, cookies);
        for(int i=0;i<courseInfoList.size();++i)
        {
            courseDao.save(courseInfoList.get(i));
        }
    }

    @Override
    public List<CourseInfo> SearchCourseInfo(SearchCourseInfoParams searchCourseInfoParams)
    {
        return courseDao.findCourse(searchCourseInfoParams);
    }

    /**
     * parse String unparsed containing Teacher_id & Teacher_name
     * unparsed = "teacher_id|teacher_name"
     */
    private void parseTeacher(String unparsed, ClassInfo info){
        if(unparsed == null){
            System.out.println("no teacher of this" + info.getCourse_id());
            return;
        }

        String[] strs = unparsed.split("\\|");
        info.setTeacher_id(strs[0]);
        info.setTeacher_name(strs[1]);
    }

    /**
     * parse String unparsed = "星期*第a-b节{c-d周}"
     * to form ClassSegment.
     */
    private void parseCourseTime(String unparsed, ClassSegment segment) {
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

    /**
     * parse String unparsed = "Time;Time;Time|Classroom;Classroom;Classroom"
     * to List of ClassSegment
     */
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
        for (int i = 0; i < classrooms.length; i++) {
            segments.get(i).setClassroom(classrooms[i]);
        }
    }


    /**
     * transform Object RawCourseInfo to Object CourseInfo
     */
    public List<CourseInfo> parseRawCourseInfo(List<RawCourseInfo> rawCourseInfos) {
        Map<String, CourseInfo> map = new HashMap<String, CourseInfo>();  /** course id => course info , Hashmap for better efficiency*/
        for(RawCourseInfo info : rawCourseInfos){
            CourseInfo courseInfo;
            /* 分析课程信息 */
            String courseID = info.getCourse_id();
            if (!map.containsKey(courseID)) { /* 不存在相关Course记录就创建新的。*/
                courseInfo = new CourseInfo();
                courseInfo.setCourse_id(courseID);
                courseInfo.setCourse_name(info.getCourse_name());
                courseInfo.setCourse_hours(info.getHours());
                courseInfo.setCourse_credits(info.getCredits());
                courseInfo.setCourse_hours(info.getHours());
                courseInfo.setGeneral(info.getGeneral_course().equals("是"));
                courseInfo.setGeneral_type(info.getGeneral_type());
                courseInfo.setClasses(new ArrayList<>());
            } else courseInfo = map.get(courseID); /* 存在就读取现有记录*/

            /* 分析教学班信息 */
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

            /* 往对应课程里添加一个 教学班信息*/
            courseInfo.getClasses().add(classInfo);

            /* 新纪录 或 修改过的记录  写回map*/
            map.put(courseID,courseInfo);
        }
        /* 将map中保存的数据转成 List */
        ArrayList<CourseInfo> courseInfos = new ArrayList<>();
        for(CourseInfo info : map.values()){
            courseInfos.add(info);
        }
        return courseInfos;
    }

    private List<CourseInfo> updateCourseTable(String requestUrl, String Cookie) throws IOException {//TODO post-form like LZW
        String res = "";
        StringBuffer buffer = new StringBuffer();

        // set request url & Cookie & other request headlines.
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
        String postBody = "xnm=" + search_course_year + "&xqm=" + search_course_semester +
                "&_search=false&nd=1561987754238&queryModel.showCount=" + receive_course_number_limit + "&queryModel.currentPage=1&queryModel.sortName=&queryModel.sortOrder=asc";
        osw.write(postBody);
        osw.flush(); //不flush 发生了bug，等下试试\n

        // get response stream save to res
        InputStream inputStream = conn.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream,"utf-8");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String str = null;
        while ((str = bufferedReader.readLine()) != null){
            buffer.append(str);
        }
        res = buffer.toString();

        // parse String res to JSON object
        RawCourseResponse response = JSON.parseObject(res,RawCourseResponse.class);
        List<CourseInfo> courseInfos = parseRawCourseInfo(response.getRawCourseInfo());
        return courseInfos;
    }
}
