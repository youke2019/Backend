package com.yoke.backend.Controller.Manager;

import com.yoke.backend.Entity.Manager.SystemMessage;
import com.yoke.backend.Entity.Tools.FileNameUtil;
import com.yoke.backend.Entity.Tools.FileUploadUtil;
import com.yoke.backend.Service.Manager.AdminService;
import com.yoke.backend.Service.Manager.SystemMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/9/1
 * @description:
 **/
@RestController
@RequestMapping(value = "/manager")
public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    SystemMessageService systemMessageService;

    /**
     * @api {get} /manager/signin
     * @apiName ManagerSignIn
     * @apiGroup Manager
     * @apiDescription 管理员登录功能，检查了账户是否存在与密码是否正确
     * @apiParam {String} account
     * @apiParam {String} password
     * @apiSuccessExample Response-Example:
     * {
     *  "error_msg":"password incorrect",
     *  "success":false
     * }
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "/signin",method = RequestMethod.GET)
    public String signIn(String account,String password)
    {
        return adminService.signIn(account, password);
    }

    /**
     * @api {get} /manager/signup
     * @apiName ManagerSignUp
     * @apiGroup Manager
     * @apiDescription 管理员注册，检查了账户名是否已经存在
     * @apiParam {String} account
     * @apiParam {String} password
     * @apiSuccessExample Response-Example:
     * {
     *     "error_msg":"account already exists",
     *     "success":false
     * }
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "signup",method = RequestMethod.GET)
    public String signUp(String account,String password)
    {
        if(account==""||password=="")
            return "need enough params";
        return adminService.signUp(account, password);
    }

    /**
     * @api {post} /manager/systemMessage/add
     * @apiName addSystemMessage
     * @apiGroup Manager
     * @apiDescription 添加系统消息
     * @apiSuccessExample Request-Example:
     *     {
     * 	"admin_id":1,
     * 	"content":"全部做完，听我的",
     * 	"image_url":"www.google.com"
     * }
     * @param systemMessage
     * @return
     */
    @RequestMapping(value = "systemMessage/add",method =RequestMethod.POST)
    @ResponseBody
    public String addSystemMessage(@RequestBody SystemMessage systemMessage)
    {
        return systemMessageService.addSystemMessage(systemMessage);
    }

    /**
     * @api {get} /manager/systemMessage/find
     * @apiName findSystemMessage
     * @apiGroup Manager
     * @apiDescription 找出最近发布的n则系统消息
     * @apiParam {Integer} number
     * @param number
     * @return
     */
    @RequestMapping(value = "systemMessage/find",method = RequestMethod.GET)
    public List<SystemMessage> findSystemMessage(Integer number)
    {
        return systemMessageService.findSystemMessage(number);
    }

    /**
     * @api {post}  /manager/systemMessage/upload
     * @apiName uploadFile
     * @apiDescription 上传图片或者视频文件
     * @apiGroup Manager
     * @apiParam {file} file
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "systemMessage/upload",method = RequestMethod.POST)
    @ResponseBody
    public String uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request)
    {
        String localPath="/media/images";
        String fileName=file.getOriginalFilename();
        fileName= FileNameUtil.getFileName(fileName);
        File dest=new File(localPath+fileName);
        if(FileUploadUtil.upload(file, localPath, fileName)) {
            // 将上传的文件写入到服务器端文件夹
            // 获取当前项目运气的完整url
            String requestURL = request.getRequestURL().toString();
            // 获取当前项目的请求路径url
            String requestURI = request.getRequestURI();
            // 得到去掉了uri的路径
            String url = requestURL.substring(0, requestURL.length() - requestURI.length() + 1);
            url += "images/" + fileName;
            System.out.println(url);
            return url;
        }
        // 返回
        return "fault";
    }

    /**
     * @api {get} /Manager/systemMessage/delete
     * @apiName deleteSystemMessage
     * @apiGroup Manager
     * @apiDescription 删除系统消息
     * @apiParam {Integer} message_id
     * @param message_id
     * @return
     */
    @RequestMapping(value = "systemMessage/delete",method = RequestMethod.GET)
    public String deleteSystemMessage(Integer message_id)
    {
        return systemMessageService.deleteSystemMessage(message_id);
    }
}
