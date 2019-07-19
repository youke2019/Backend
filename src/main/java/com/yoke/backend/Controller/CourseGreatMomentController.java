package com.yoke.backend.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/19
 * @description:
 **/
@RestController
@RequestMapping(value = "courses/moments")
public class CourseGreatMomentController {
    @RequestMapping(value = "uploadImg",method = RequestMethod.POST)
    @ResponseBody
    public String uploadImg(@RequestParam(value = "img")MultipartFile img, HttpServletResponse response)
    {
        return "wait";
    }
}
