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

    SearchCourseInfoParams searchCourseInfoParams=new SearchCourseInfoParams();
    List<CourseInfo> courseInfoList;

    /*通过类型搜索课程数量测试*/
    List<String> originGenearlTypes=searchCourseInfoParams.getGeneral_types();
    List<String> genearltypes= Arrays.asList("人文学科");
    searchCourseInfoParams.setGeneral_types(genearltypes);
    courseInfoList=courseService.SearchCourseInfo(searchCourseInfoParams);
    Assert.assertEquals(77,courseInfoList.size());
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
    Assert.assertEquals(718,courseInfoList.size());
    searchCourseInfoParams.setWeekdays(originWeekDays);

    /*搜索全部课程数量测试*/
    searchCourseInfoParams=new SearchCourseInfoParams();
    courseInfoList=courseService.SearchCourseInfo(searchCourseInfoParams);
    Assert.assertEquals(3031,courseInfoList.size());
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
