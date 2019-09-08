package com.yoke.backend.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yoke.backend.Dao.CourseMessage.CourseCommentReplyDao;
import com.yoke.backend.Dao.CourseMessage.Report.CourseAnswerReportDao;
import com.yoke.backend.Dao.CourseMessage.Report.CourseCommentReportDao;
import com.yoke.backend.Dao.CourseMessage.Report.CourseMomentReportDao;
import com.yoke.backend.Dao.CourseMessage.Report.CourseQuestionReportDao;
import com.yoke.backend.Entity.CourseMessage.CourseCommentReply;
import com.yoke.backend.Entity.CourseMessage.Report.CourseAnswerReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseCommentReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseMomentReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseQuestionReport;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;

/** 
* ReportController Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 8, 2019</pre> 
* @version 1.0 
*/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportControllerTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
}
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private CourseAnswerReportDao courseAnswerReportDao;

    @Autowired
    private CourseCommentReportDao courseCommentReplyDao;

    @Autowired
    private CourseMomentReportDao courseMomentReportDao;

    @Autowired
    private CourseQuestionReportDao courseQuestionReportDao;
/** 
* 
* Method: reportComment(@RequestBody CourseCommentReport courseCommentReport) 
* 
*/ 
@Test
@Transactional
public void testReportComment() throws Exception {
    CourseCommentReport courseCommentReport = new CourseCommentReport();
    courseCommentReport.setCourse_comment_id(4);
    courseCommentReport.setUser_id("01231");
    courseCommentReport.setCourse_comment_report_reason("");

    String responce = testRestTemplate.postForObject("/report/report/comment",courseCommentReport,String.class);
    Assert.assertThat(responce,equalTo("success"));
} 

/** 
* 
* Method: reportAnswer(@RequestBody CourseAnswerReport courseAnswerReport) 
* 
*/ 
@Test
@Transactional
public void testReportAnswer() throws Exception {
    CourseAnswerReport courseAnswerReport = new CourseAnswerReport();
    courseAnswerReport.setUser_id("01231");
    courseAnswerReport.setAnswer_report_reason("");
    courseAnswerReport.setAnswer_id(5555);
    String responce = testRestTemplate.postForObject("/report/report/answer",courseAnswerReport,String.class);
    Assert.assertThat(responce,equalTo("success"));
} 

/** 
* 
* Method: reportQuestion(@RequestBody CourseQuestionReport courseQuestionReport) 
* 
*/ 
@Test
@Transactional
public void testReportQuestion() throws Exception {
    CourseQuestionReport courseAnswerReport = new CourseQuestionReport();
    courseAnswerReport.setUser_id("01231");
    courseAnswerReport.setQuestion_report_reason("");
    courseAnswerReport.setQuestion_id(17555);
    String responce = testRestTemplate.postForObject("/report/report/question",courseAnswerReport,String.class);
    Assert.assertThat(responce,equalTo("success"));
} 

/** 
* 
* Method: reportMoment(@RequestBody CourseMomentReport courseMomentReport) 
* 
*/ 
@Test
@Transactional
public void testReportMoment() throws Exception {
    CourseMomentReport courseAnswerReport = new CourseMomentReport();
    courseAnswerReport.setUser_id("01231");
    courseAnswerReport.setVideo_report_reason("");
    courseAnswerReport.setVideo_id(19011);
    String responce = testRestTemplate.postForObject("/report/report/moment",courseAnswerReport,String.class);
    Assert.assertThat(responce,equalTo("success"));
} 

/** 
* 
* Method: getHandledComments() 
* 
*/ 
@Test
@Transactional
public void testGetHandledComments() throws Exception { 
    String responce = testRestTemplate.getForObject("/report/getHandled/comments",String.class);
    List<CourseCommentReport> result = JSON.parseArray(responce, CourseCommentReport.class);
    List<CourseCommentReport> tmp = courseCommentReplyDao.findAllHandled();
    Assert.assertThat(result.size(),equalTo(tmp.size()));
} 

/** 
* 
* Method: getHandledAnswers() 
* 
*/ 
@Test
@Transactional
public void testGetHandledAnswers() throws Exception {
    String responce = testRestTemplate.getForObject("/report/getHandled/answers",String.class);
    List<CourseAnswerReport> result = JSON.parseArray(responce, CourseAnswerReport.class);
    List<CourseAnswerReport> tmp = courseAnswerReportDao.findAllHandled();
    Assert.assertThat(result.size(),equalTo(tmp.size()));
} 

/** 
* 
* Method: getHandledQuestions() 
* 
*/ 
@Test
@Transactional
public void testGetHandledQuestions() throws Exception {
    String responce = testRestTemplate.getForObject("/report/getHandled/questions",String.class);
    List<CourseQuestionReport> result = JSON.parseArray(responce, CourseQuestionReport.class);
    List<CourseQuestionReport> tmp = courseQuestionReportDao.findAllHandled();
    Assert.assertThat(result.size(),equalTo(tmp.size()));
} 

/** 
* 
* Method: getHanledMoments() 
* 
*/ 
@Test
@Transactional
public void testGetHanledMoments() throws Exception {
    String responce = testRestTemplate.getForObject("/report/getHandled/moments",String.class);
    List<CourseMomentReport> result = JSON.parseArray(responce, CourseMomentReport.class);
    List<CourseMomentReport> tmp = courseMomentReportDao.findAllHandled();
    Assert.assertThat(result.size(),equalTo(tmp.size()));
} 

/** 
* 
* Method: getReportedComments() 
* 
*/ 
@Test
@Transactional
public void testGetReportedComments() throws Exception {
    String responce = testRestTemplate.getForObject("/report/getReported/comments",String.class);
    List<CourseCommentReport> result = JSON.parseArray(responce, CourseCommentReport.class);
    List<CourseCommentReport> tmp = courseCommentReplyDao.findAllReported();
    Assert.assertThat(result.size(),equalTo(tmp.size()));
}

/** 
* 
* Method: getReportedAnswers() 
* 
*/ 
@Test
@Transactional
public void testGetReportedAnswers() throws Exception {
    String responce = testRestTemplate.getForObject("/report/getReported/answers",String.class);
    List<CourseAnswerReport> result = JSON.parseArray(responce, CourseAnswerReport.class);
    List<CourseAnswerReport> tmp = courseAnswerReportDao.findAllReported();
    Assert.assertThat(result.size(),equalTo(tmp.size()));
} 

/** 
* 
* Method: getReportedQuestions() 
* 
*/ 
@Test
@Transactional
public void testGetReportedQuestions() throws Exception {
    String responce = testRestTemplate.getForObject("/report/getReported/questions",String.class);
    List<CourseQuestionReport> result = JSON.parseArray(responce, CourseQuestionReport.class);
    List<CourseQuestionReport> tmp = courseQuestionReportDao.findAllReported();
    Assert.assertThat(result.size(),equalTo(tmp.size()));
} 

/** 
* 
* Method: getReportedMoments() 
* 
*/ 
@Test
@Transactional
public void testGetReportedMoments() throws Exception {
    String responce = testRestTemplate.getForObject("/report/getReported/moments",String.class);
    List<CourseMomentReport> result = JSON.parseArray(responce, CourseMomentReport.class);
    List<CourseMomentReport> tmp = courseMomentReportDao.findAllReported();
    Assert.assertThat(result.size(),equalTo(tmp.size()));
} 

/** 
* 
* Method: handleComment(@RequestParam Integer course_comment_report_id, @RequestParam Integer handler) 
* 
*/ 
@Test
@Transactional
public void testHandleComment() throws Exception {
    Map<String,String> params = new HashMap<>();
    params.put("course_comment_report_id","2");
    params.put("handler","1");

    String response=testRestTemplate.getForObject("/report/handle/comment?course_comment_report_id={course_comment_report_id}&handler={handler}",String.class,params);

    Assert.assertNotEquals(true,equalTo(response));
}

/** 
* 
* Method: handleAnswer(@RequestParam Integer course_answer_report_id, @RequestParam Integer handler) 
* 
*/ 
@Test
@Transactional
public void testHandleAnswer() throws Exception {
    Map<String,String> params = new HashMap<>();
    params.put("course_answer_report_id","1");
    params.put("handler","1");

    String response=testRestTemplate.getForObject("/report/handle/answer?course_answer_report_id={course_answer_report_id}&handler={handler}",String.class,params);

    Assert.assertNotEquals(true,equalTo(response));
} 

/** 
* 
* Method: handleQuestion(@RequestParam Integer course_question_report_id, @RequestParam Integer handler) 
* 
*/ 
@Test
@Transactional
public void testHandleQuestion() throws Exception {

    Map<String,String> params = new HashMap<>();
    params.put("course_question_report_id","1");
    params.put("handler","1");

    String response=testRestTemplate.getForObject("/report/handle/question?course_question_report_id={course_question_report_id}&handler={handler}",String.class,params);
    Assert.assertNotEquals(true,equalTo(response));
} 

/** 
* 
* Method: handleMoment(Integer report_id, Integer handler) 
* 
*/ 
@Test
@Transactional
public void testHandleMoment() throws Exception {
    Map<String,String> params = new HashMap<>();
    params.put("report_id","1");
    params.put("handler","1");

    String response=testRestTemplate.getForObject("/report/handle/moment?report_id={report_id}&handler={handler}",String.class,params);

    Assert.assertNotEquals(true,equalTo(response));}


} 
