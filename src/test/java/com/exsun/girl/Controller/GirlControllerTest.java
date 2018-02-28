package com.exsun.girl.Controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getGirlList() throws Exception {
        //执行状态测试
        mvc.perform(MockMvcRequestBuilders.get("/girls/list")).andExpect(MockMvcResultMatchers.status().isOk());

        //执行内容测试
       // mvc.perform(MockMvcRequestBuilders.get("/girls/list")).andExpect(MockMvcResultMatchers.content().string("abcd"));
    }
}