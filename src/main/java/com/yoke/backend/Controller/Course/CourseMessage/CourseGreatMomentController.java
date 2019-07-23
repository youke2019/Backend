package com.yoke.backend.Controller.Course.CourseMessage;
import com.yoke.backend.Entity.CourseMessage.CourseMoment;
import com.yoke.backend.Entity.CourseMessage.CourseMomentComment;
import com.yoke.backend.Entity.Tools.FileNameUtil;
import com.yoke.backend.Entity.Tools.FileUploadUtil;
import com.yoke.backend.Service.Course.CourseMessage.CourseMomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/19
 * @description:
 **/
@RestController
@RequestMapping(value = "courses/moments")
public class CourseGreatMomentController {

    @Autowired
    CourseMomentService courseMomentService;



    /**
     * @param serialNumber1
     * @param serialNumber2
     * @return
     */
    @RequestMapping(value = "find")
    public List<CourseMoment> findByTimeOrder(Integer serialNumber1, Integer serialNumber2) {
        return courseMomentService.findByTimeOrder(serialNumber1, serialNumber2);
    }

    /**
     * @param user_id
     * @return
     * @api {get} /courses/moments/findAll
     * @apiName findCourseMoment
     * @apiDescription 查找所有精彩瞬间
     * @apiGroup CourseMoment
     * @apiParam {String} user_id
     */
    @RequestMapping(value = "findAll")
    public List<CourseMoment> findAll(String user_id) {
        return courseMomentService.findAll(user_id);
    }

    /**
     * @param video_id
     * @param user_id
     * @return
     * @api {get} /courses/moments/praise
     * @apiName praiseCourseMoment
     * @apiDescription 对课程精彩瞬间进行点赞
     * @apiGroup CourseMoment
     * @apiParam {Integer} video_id
     * @apiParam {Integer} user_id
     */
    @RequestMapping(value = "praise")
    public String praiseCourseMoment(Integer video_id, String user_id) {
        courseMomentService.praiseCourseMoment(video_id, user_id);
        return "success";
    }

    /**
     * @param video_id
     * @param user_id
     * @return
     * @api {get} /courses/moments/unpraise
     * @apiName unpraiseCourseMoment
     * @apiDescription 对课程精彩瞬间取消点赞
     * @apiGroup CourseMoment
     * @apiParam {Integer} video_id
     * @apiParam {Integer} user_id
     */
    @RequestMapping(value = "unpraise")
    public String unpraiseCourseMoment(Integer video_id, String user_id) {
        courseMomentService.unpraiseCourseMoment(video_id, user_id);
        return "success";
    }

    /**
     * @param courseMomentComment
     * @return
     * @api {post} /courses/moments/comment
     * @apiName commentCourseMoment
     * @apiGroup CourseMoment
     * @apiDescription 评论课程精彩瞬间
     * @apiSuccessExample Post-Example:
     * {
     * "video_id":5,
     * "user_id":"01231",
     * "video_comment_content":"有趣"
     * }
     */
    @RequestMapping(value = "comment", method = RequestMethod.POST)
    @ResponseBody
    public String commentCourseMoment(@RequestBody CourseMomentComment courseMomentComment) {
        courseMomentService.commentCourseMoment(courseMomentComment);
        return "success";
    }

    /**
     /**
     * @api {post} courses/moments/post
     * @apiName postCourseMoment
     * @apiDescription 发布课程精彩瞬间
     * @apiGroup CourseMoment
     * @apiSuccessExample Post-Example:
     * {
     * "user_id":"01231",
     * "post_text":"我这门课是木课，嘻嘻",
     * "video_type":"i",   //i:图片，v:视频，n:无
     * "image_url":"ipads.sjtu.edu.cn/se101"
     * }
     * @param courseMoment
     * @return
     */
    @RequestMapping(value = "post", method = RequestMethod.POST)
    @ResponseBody
    public String postCourseMoment(@RequestBody CourseMoment courseMoment) {
        courseMomentService.postCourseMoment(courseMoment);
        return "success";
    }

    /**
     * @api {post}  courses/moment/upload
     * @apiName uploadFile
     * @apiDescription 上传图片或者视频文件
     * @apiGroup CourseMoment
     * @apiParam {file} file
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String uploadImg(@RequestParam("file")MultipartFile file, HttpServletRequest request)
    {
        System.out.println("here");
        System.out.println(file.getOriginalFilename());
        String localPath="/media/images";
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
            url+="images/"+ fileName;
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
     * @api {get} images/
     * @apiName getFile
     * @apiDescription 获取图片或者视频文件
     * @apiGroup CourseMoment
     * @apiParam http://47.103.30.166:8000/images/e88affabfdb142d2b70e13bf9ea086d7.mp4
     */

}
