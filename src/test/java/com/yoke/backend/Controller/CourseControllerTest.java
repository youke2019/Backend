package com.yoke.backend.Controller;

import com.yoke.backend.Entity.ClassInfo;
import com.yoke.backend.Entity.ClassSegment;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CourseControllerTest {



    @Test
    public void init() {

    }

    @Test
    public void updateCourseTable() throws IOException {
        CourseController controller = new CourseController();
        controller.updateCourseTable("http://i.sjtu.edu.cn/design/funcData_cxFuncDataList.html?func_widget_guid=8B04B7BBB49C4455E0530200A8C06482&gnmkdm=N2199113&su=517021911099","_ga=GA1.3.516706731.1530239162; _gid=GA1.3.2034703066.1561962820; kc@i.sjtu.edu.cn=ffffffff0973176845525d5f4f58455e445a4a423660; JSESSIONID=AD2D90F8FD91A4A4BED6623017ADFD1E");
    }

    @Test
    public void parseRawCourseInfo(){
        }

    /**
    public void parseTeacher() {
        CourseController controller = new CourseController();
        ClassInfo info = new ClassInfo();
        String unparsed = "11145|臧斌宇";
        controller.parseTeacher(unparsed,info);
        assertEquals("11145",info.getTeacher_id() );
        assertEquals("臧斌宇",info.getTeacher_name());
    }
*//**
    public void parseCourseArrangement() {
        CourseController controller = new CourseController();
        ArrayList<ClassSegment> classSegments = new ArrayList<>();
        String unparsed  = "星期二第7-8节{1-16周};星期二第7-8节{1-16周};星期五第3-4节{1-16周};星期五第3-4节{1-16周}|东上院102;东上院102;东上院102;东上院102";
        controller.parseCourseArrangement(unparsed,classSegments);
        ArrayList<ClassSegment> expect = new ArrayList<>();
        assertEquals(5,(long)classSegments.get(2).getWeek());
        assertEquals(3,(long)classSegments.get(2).getBegin_sec());
        assertEquals(4,(long)classSegments.get(2).getEnd_sec());
        assertEquals(1,(long)classSegments.get(2).getBegin_week());
        assertEquals(16,(long)classSegments.get(2).getEnd_week());
        assertEquals("东上院102",classSegments.get(2).getClassroom());

    }*/

}