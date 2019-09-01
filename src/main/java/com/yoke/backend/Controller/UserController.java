package com.yoke.backend.Controller;

import com.alibaba.fastjson.JSONObject;
import com.yoke.backend.Entity.Tools.FileNameUtil;
import com.yoke.backend.Entity.Tools.FileUploadUtil;
import com.yoke.backend.Entity.User.Feedback;
import com.yoke.backend.Entity.User.User;
import com.yoke.backend.Service.User.FeedbackService;
import com.yoke.backend.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    FeedbackService feedbackService;

    /**
     * @api {get} /users/specific
     * @apiDescription 根据Id获取用户信息
     * @apiName getUserByID
     * @apiGroup users
     * @apiVersion 1.0.0
     * @apiParam {String} id
     *@apiHeaderExample {json} Response-Example:
     * {
     *         "ID":"userID-string",
     *         "name":"刘政委",
     *         "major":"软件工程",
     *         "admissionYear":2017,
     *         "sex": 'M' or 'F',
     *         "department": "电子信息与电气工程学院",
     *         "nickname": "昵称",
     *         "banned": True or False, //封禁
     * }
     * */
    @RequestMapping(value = "/specific", method = RequestMethod.GET)
    public User getUserByID(@RequestParam("id") String id) {
        return userService.GetUserByID(id);
    }

    /**@api {get} /users/ban
     * @apiDescription 封禁
     * @apiName banUser
     * @apiGroup users
     * @apiVersion 1.0.0
     *
     * @apiParam {String} id
     */
    @RequestMapping(value = "/ban", method = RequestMethod.POST)
    public void banUser(@RequestParam String id) {
        userService.banUser(id);
    }

    /**
     * @api {get} /users/unban
     * @apiDescription 解禁
     * @apiName unbanUser
     * @apiGroup users
     * @apiVersion 1.0.0
     * @apiParam {String} id

     */
    @RequestMapping(value = "/unban", method = RequestMethod.POST)
    public void unBanUser(@RequestParam String id) {
        userService.unBanUser(id);
    }

    /**
     * @api {get} /users/all
     * @apiDescription 获取所有用户信息
     * @apiName getAllUser
     * @apiGroup users
     * @apiVersion 1.0.0
     *@apiHeaderExample {json} Response-Example:
     * [
     *     {
     *         "ID":"userID-string",
     *         "name":"刘政委",
     *         "major":"软件工程",
     *         "admissionYear":2017,
     *         "sex": 'M' or 'F',
     *         "department": "电子信息与电气工程学院",
     *         "nickname": "昵称",
     *         "banned": True or False, //封禁
     *     }
     * ]
     * */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAllUser() {
        return userService.findAll();
    }

    /*
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public User getUserInfoById(@RequestParam("u_id") String id) {
        return userService.GetUserByID(id);
    }
    */


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUserInfo(@RequestBody User user) {
        JSONObject resp = new JSONObject();
        User userByNickname = userService.findByNickname(user.getNickname());
        System.out.println(user.getId());
       if(userByNickname!=null) System.out.println(userByNickname.getId());
       if (userByNickname != null && !userByNickname.getId().equals( user.getId())) {
            System.out.println("Duplicate Nickname");
            resp.put("success", false);
            resp.put("error_msg", "Duplicate Nickname");
            return resp.toJSONString();
        }
        userService.save(user);
        System.out.println("update success");
        resp.put("success", true);
        return resp.toJSONString();
    }

    /**
     * @api {post}  /users/avatar/upload
     * @apiName uploadFile
     * @apiDescription 上传头像
     * @apiGroup users
     * @apiParam {file} file
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/avatar/upload",method = RequestMethod.POST)
    @ResponseBody
    public String uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request)
    {
        System.out.println("here");
        System.out.println(file.getOriginalFilename());
        String localPath="/media/avators";
        String fileName=file.getOriginalFilename();
        fileName= FileNameUtil.getFileName(fileName);
        File dest=new File(localPath+fileName);
        if(FileUploadUtil.upload(file, localPath, fileName)){
            // 将上传的文件写入到服务器端文件夹
            // 获取当前项目运气的完整url
            String requestURL = request.getRequestURL().toString();
            // 获取当前项目的请求路径url
            String requestURI = request.getRequestURI();
            // 得到去掉了uri的路径
            String url = requestURL.substring(0, requestURL.length()-requestURI.length() + 1);
            url+="avators/"+ fileName;
            System.out.println(url);
            return  url;

        }
        else{
            System.out.println("未进入upload函数");
        }
        // 返回
        return "fault";

    }

    /**
     * @api {post} /users/feedback/add
     * @apiName addFeedback
     * @apiDescription 添加反馈
     * @apiGroup users
     * @apiSuccessExample Request-Example:
     *     {
     *         "user_id": "ID001",
     *         "content": "我不要你觉得，我要我觉得"
     *     }
     * @param feedback
     * @return
     */
    @RequestMapping(value = "/feedback/add",method = RequestMethod.POST)
    @ResponseBody
    public String uploadFeedback(@RequestBody Feedback feedback)
    {
        JSONObject response=new JSONObject();
        if(feedback.getUser_id()=="")
        {
            response.put("error_msg","none user_id");
            return  response.toJSONString();
        }
        if(feedback.getContent()=="")
        {
            response.put("error_msg","no content");
            return response.toJSONString();
        }
        feedbackService.save(feedback);
        response.put("success",true);
        return response.toJSONString();
    }

    /**
     * @api {get} /users/feedback/all
     * @apiName allFeedback
     * @apiDescription 查看所有反馈
     * @apiGroup users
     * @return
     */
    @RequestMapping(value = "feedback/all",method = RequestMethod.GET)
    public List<Feedback> allFeedback()
    {
        return feedbackService.findAll();
    }
}
