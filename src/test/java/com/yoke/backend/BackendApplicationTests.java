package com.yoke.backend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BackendApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void contextLoads() throws Exception {
        mockMvc.perform(
                post("/course/update")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .param("url","http://i.sjtu.edu.cn/design/funcData_cxFuncDataList.html?func_widget_guid=8B04B7BBB49C4455E0530200A8C06482&gnmkdm=N2199113&su=517021911099")
                    .param("Cookie","kc@i.sjtu.edu.cn=ffffffff0973176545525d5f4f58455e445a4a423660; JSESSIONID=0A45BE81D3579BF037DD5C6D2FC9C2A0")
        );
    }

}
