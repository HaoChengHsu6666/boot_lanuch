package com.chris.bootlaunch.Controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
public class ArticleVOControllerTest {

    //mock物件
    private static MockMvc mockMvc;

    //方式一，執行全部程式之前，建構ArticleController上的API方法
    @BeforeAll
    static void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
    }

    @Test
    public void  saveArticle() throws Exception{

        String article = "{\n" +
                "    \"id\" : 1,\n" +
                "    \"author\": \"R_hsu\",\n" +
                "    \"title\": \"青銅到王者開發Springboot\",\n" +
                "    \"content\": \"KeepLearning\",\n" +
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