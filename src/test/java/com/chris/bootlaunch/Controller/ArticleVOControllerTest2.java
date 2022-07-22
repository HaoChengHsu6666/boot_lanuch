package com.chris.bootlaunch.Controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
//自動建構MockMVC的物件
@AutoConfigureMockMvc
@SpringBootTest
//繼承的位置，為當前環境添加Spring運行容器的環境
@ExtendWith(SpringExtension.class)
public class ArticleVOControllerTest2 {

    //mock物件
    @Resource
    private MockMvc mockMvc;

    //方式二，不做此段(執行全部程式之前，建構ArticleController上的API方法)，在class上方加上自動注入的註解
//    @BeforeAll
//    static void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
//    }

    @Test
    public void  saveArticle() throws Exception{

        String article = "{\n" +
                "    \"id\" : 1,\n" +
                "    \"author\": \"R_hsu\",\n" +
                "    \"title\": \"青銅到王者開發Springboot\",\n" +
                "    \"content\": \"使用MockMVC模擬前端打過來的數據\",\n" +
                "    \"createTime\": \"2022/07/11 15:31:33\",\n" +
                "    \"reader\": [{\"name\":\"hsu\",\"age\":21},{\"name\":\"hua\",\"age\":18}]\n" +
                "}";

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .request(HttpMethod.POST, "/articles")
                        .contentType("application/json")
                        .content(article)
        )
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())// Http status: 200
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("R_hsu"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(21))
                .andReturn();

        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        log.info(mvcResult.getResponse().getContentAsString());
    }
}