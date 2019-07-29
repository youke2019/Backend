package com.yoke.backend.Entity.Tools;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/21
 * @description:
 **/
@Configuration
public class UploadFileConfig extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/images/**").addResourceLocations("file:/media/images/");
        registry.addResourceHandler("/avatars/**").addResourceLocations("file:/media/avatars/");
        super.addResourceHandlers(registry);
    }

}
