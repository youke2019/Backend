package com.yoke.backend.Service.SensitiveFilter;

import org.junit.Before;
import org.junit.Test;

public class FilterServiceTest {

    FilterService service;

    @Before
    public void init() {
        try {
            service = FilterService.getInstance();
            service = FilterService.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getInstance() throws Exception {
        service = FilterService.getInstance();
    }

    @Test
    public void filter() {
        String res1 = service.filter("fadsfa包夜sefaefaefaefaef");
        String res2 = service.filter("这是一句正常的没胡派有问题的话");
        String res3 = service.filter("江泽民");
        String res4 = service.filter("去除无意义字符识江泽民别，炸.弹#配!方!!!");
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
    }

}