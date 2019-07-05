package com.yoke.backend.DaoImpl; 

import com.yoke.backend.Dao.CourseDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;

/** 
* CourseDaoImpl Tester. 
* 
* @author <Zhi Guo> 
* @since <pre>07/05/2019</pre> 
* @version 1.0 
*/ 
public class CourseDaoImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: findAll() 
* 
*/ 
@Test
public void testFindAll() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: save(CourseInfo courseInfo) 
* 
*/ 
@Test
public void testSave() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findCourseInfoByCourseId(String course_id) 
* 
*/ 
@Test
public void testFindCourseInfoByCourseId() throws Exception { 
//TODO: Test goes here...

    /*CourseDao courseDao = null;
    String result=courseDao.findCourseInfoByCourseId("SE101").get(0).getCourse_name();
    Assert.assertEquals("not find successfully", "计算机系统基础（1）",result);*/
} 

/** 
* 
* Method: findCourseInfoByCourseName(String course_name) 
* 
*/ 
@Test
public void testFindCourseInfoByCourseName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findCourseInfoByTeacherName(String teacher_name) 
* 
*/ 
@Test
public void testFindCourseInfoByTeacherName() throws Exception { 
//TODO: Test goes here... 
} 


} 
