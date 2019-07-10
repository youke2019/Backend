package com.yoke.backend.ServiceImpl; 

import com.yoke.backend.Entity.Course.CourseInfo;
import com.yoke.backend.Entity.Course.SearchCourseInfoParams;
import com.yoke.backend.Service.CourseService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/** 
* CourseServiceImpl Tester. 
* 
* @author <Zhi Guo> 
* @since <pre>07/05/2019</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceImplTest { 

    @Autowired
    CourseService courseService;
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: GetCourseFromJWC(String url, String cookies) 
* 
*/ 
@Test
public void testGetCourseFromJWC() throws Exception { 
//TODO: Test goes here...

} 

/** 
* 
* Method: SearchCourseInfo(SearchCourseInfoParams searchCourseInfoParams) 
* 
*/ 
@Test
public void testSearchCourseInfo() throws Exception { 
//TODO: Test goes here...

    /*常规测试*/

    SearchCourseInfoParams searchCourseInfoParams=new SearchCourseInfoParams();
    List<CourseInfo> courseInfoList;

    /*通过类型搜索课程数量测试*/
    List<String> originGenearlTypes=searchCourseInfoParams.getGeneral_types();
    List<String> genearltypes= Arrays.asList("人文学科");
    searchCourseInfoParams.setGeneral_types(genearltypes);
    courseInfoList=courseService.SearchCourseInfo(searchCourseInfoParams);
    Assert.assertEquals(75,courseInfoList.size());
    searchCourseInfoParams.setGeneral_types(originGenearlTypes);

    /*通过教学楼搜索课程数量测试*/
    searchCourseInfoParams.setBuilding("东上院");
    courseInfoList=courseService.SearchCourseInfo(searchCourseInfoParams);
    Assert.assertEquals(431,courseInfoList.size());
    searchCourseInfoParams.setBuilding("");

    /*通过课程段所在工作日查询*/
    List<Integer> originWeekDays=searchCourseInfoParams.getWeekdays();
    List<Integer> weekDays=Arrays.asList(3);
    searchCourseInfoParams.setWeekdays(weekDays);
    courseInfoList=courseService.SearchCourseInfo(searchCourseInfoParams);
    Assert.assertEquals(715,courseInfoList.size());
    searchCourseInfoParams.setWeekdays(originWeekDays);

    /*通过学分搜索课程数量测试*/
    List<Double> originCredits=searchCourseInfoParams.getCourse_credits();
    List<Double> credits=Arrays.asList(2.0);
    searchCourseInfoParams.setCourse_credits(credits);
    courseInfoList=courseService.SearchCourseInfo(searchCourseInfoParams);
    Assert.assertEquals(1434,courseInfoList.size());
    searchCourseInfoParams.setCourse_credits(originCredits);

    /*通过学院开设课程数量测试*/
    searchCourseInfoParams.setDept_name("电子信息");
    courseInfoList=courseService.SearchCourseInfo(searchCourseInfoParams);
    Assert.assertEquals(424,courseInfoList.size());
    searchCourseInfoParams.setDept_name("");

    /*通过年份测试*/
    /*List<Integer> originSemester=searchCourseInfoParams.getSemester();
    List<Integer> semester=Arrays.asList(3);
    searchCourseInfoParams.setSemester(semester);
    courseInfoList=courseService.SearchCourseInfo(searchCourseInfoParams);
    Assert.assertEquals(250,courseInfoList.size());
    searchCourseInfoParams.setSemester(originSemester);*/


} 

/** 
* 
* Method: parseRawCourseInfo(List<RawCourseInfo> rawCourseInfos) 
* 
*/ 
@Test
public void testParseRawCourseInfo() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updateCourseTable(String requestUrl, String Cookie) 
* 
*/ 
@Test
public void testUpdateCourseTable() throws Exception { 
//TODO: Test goes here...
    //List<CourseInfo> courseInfoList=courseService.updateCourseTable("\"http://i.sjtu.edu.cn/design/funcData_cxFuncDataList.html?func_widget_guid=8B04B7BBB49C4455E0530200A8C06482&gnmkdm=N2199113&su=517021910503\"","_ga=GA1.3.1037536714.1553838728; UM_distinctid=16bae3ba0e48-09fd12d662a261-e343166-100200-16bae3ba0e52f; JSESSIONID=916E74DCCDFC4374085F1EDA8E14B35B; kc@i.sjtu.edu.cn=ffffffff0973176845525d5f4f58455e445a4a423660");
} 


/** 
* 
* Method: parseTeacher(String unparsed, ClassInfo info) 
* 
*/ 
@Test
public void testParseTeacher() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = CourseServiceImpl.getClass().getMethod("parseTeacher", String.class, ClassInfo.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: parseCourseTime(String unparsed, ClassSegment segment) 
* 
*/ 
@Test
public void testParseCourseTime() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = CourseServiceImpl.getClass().getMethod("parseCourseTime", String.class, ClassSegment.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: parseCourseArrangement(String unparsed, List<ClassSegment> segments) 
* 
*/ 
@Test
public void testParseCourseArrangement() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = CourseServiceImpl.getClass().getMethod("parseCourseArrangement", String.class, List<ClassSegment>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
