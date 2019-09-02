package com.yoke.backend.Controller.Manager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yoke.backend.Entity.Manager.SystemMessage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/** 
* AdminController Tester. 
* 
* @author <Zhi Guo> 
* @since <pre>09/02/2019</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdminControllerTest {


    @Autowired
    private TestRestTemplate testRestTemplate;
@Before
public void before() throws Exception {

} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: signIn(String account, String password) 
* 
*/ 
@Test
public void testSignIn() throws Exception { 
//TODO: Test goes here...
    JSONObject request=new JSONObject();
    request.put("account","001");
    request.put("password","001");
    String response=testRestTemplate.postForObject("/manager/signin",request,String.class);
    JSONObject response_json= JSONObject.parseObject(response);
    Assert.assertNotEquals(true,response_json.get("success"));

    JSONObject request1=new JSONObject();
    request1.put("account","123");
    request1.put("password","123");
    String response1=testRestTemplate.postForObject("/manager/signin",request1,String.class);
    JSONObject response1_json= JSONObject.parseObject(response1);
    Assert.assertEquals(true,response1_json.get("success"));

} 

/** 
* 
* Method: signUp(String account, String password) 
* 
*/ 
@Test
public void testSignUp() throws Exception { 
//TODO: Test goes here...
    JSONObject request1=new JSONObject();
    request1.put("account","123");
    request1.put("password","123");
    String response1=testRestTemplate.postForObject("/manager/signup",request1,String.class);
    JSONObject response1_json= JSONObject.parseObject(response1);
    Assert.assertEquals(false,response1_json.get("success"));

    JSONObject request2=new JSONObject();
    request2.put("account","786");
    request2.put("password","123");
    String response2=testRestTemplate.postForObject("/manager/signup",request2,String.class);
    JSONObject response2_json= JSONObject.parseObject(response2);
    Assert.assertEquals(true,response2_json.get("success"));
} 

/** 
* 
* Method: addSystemMessage(@RequestBody SystemMessage systemMessage) 
* 
*/ 
@Test
public void testAddSystemMessage() throws Exception { 
//TODO: Test goes here...
    JSONObject request=new JSONObject();
    request.put("admin_id",1);
    String response=testRestTemplate.postForObject("manager/systemMessage/add",request,String.class);
    JSONObject response_json=JSONObject.parseObject(response);
    Assert.assertEquals(false,response_json.get("success"));

    request.put("content","归根结底都是一个人的错");
    String response1=testRestTemplate.postForObject("manager/systemMessage/add",request,String.class);
    JSONObject response1_json=JSONObject.parseObject(response1);
    Assert.assertEquals(true,response_json.get("success"));

} 

/** 
* 
* Method: findSystemMessage(Integer number) 
* 
*/ 
@Test
public void testFindSystemMessage() throws Exception { 
//TODO: Test goes here...
    String response=testRestTemplate.getForObject("manager/systemMessage/find?number=1",String.class);
    List<SystemMessage> systemMessages= JSON.parseArray(response,SystemMessage.class);
    Assert.assertEquals(1,systemMessages.size());

} 

/** 
* 
* Method: uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) 
* 
*/ 
@Test
public void testUploadImg() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteSystemMessage(Integer message_id) 
* 
*/ 
@Test
public void testDeleteSystemMessage() throws Exception { 
//TODO: Test goes here...
    String response=testRestTemplate.getForObject("manager/systemMessage/delete?message_id=100",String.class);
    JSONObject response_json=JSONObject.parseObject(response);
    Assert.assertEquals(false,response_json.get("success"));

    response=testRestTemplate.getForObject("manager/systemMessage/delete?message_id=1",String.class);
    response_json=JSONObject.parseObject(response);
    Assert.assertEquals(true,response_json.get("success"));
} 


} 
