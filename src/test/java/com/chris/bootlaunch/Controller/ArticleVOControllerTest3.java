package com.chris.bootlaunch.Controller;

import com.chris.bootlaunch.model.ArticleVO;
import com.chris.bootlaunch.service.ArticleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
//自動建構MockMVC的物件
@AutoConfigureMockMvc
//加載上下文相關所有的been，做初始化後，注入到目前當下的容器
@SpringBootTest
//只加載指定的been做測試，做到輕量級測試的效果
//@WebMvcTest(ArticleController.class)
//繼承的位置，為當前環境添加Spring運行容器的環境
@ExtendWith(SpringExtension.class)
public class ArticleVOControllerTest3 {

    //mock物件
    @Resource
    private MockMvc mockMvc;

    @MockBean
    private ArticleService articleService;

    //執行全部程式之前，建構ArticleController上的API方法
//    @BeforeAll
//    static void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
//    }

    @Test
    public void saveArticle() throws Exception {

        String article = "{\n" +
                "    \"id\" : 1,\n" +
                "    \"author\": \"R_hsu\",\n" +
                "    \"title\": \"青銅到王者開發Springboot\",\n" +
                "    \"content\": \"做出了一個Mockito假的測試環境，模擬無法或不能調用Dao層的情況做出的測試環境\",\n" +
                "    \"createTime\": \"2022/07/11 15:31:33\",\n" +
                "    \"reader\": [{\"name\":\"hsu\",\"age\":21},{\"name\":\"hua\",\"age\":18}]\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        ArticleVO articleVOObj = objectMapper.readValue(article, ArticleVO.class);

        //打樁(給出一個假的返回結果，模擬無法或不能調用Dao層的情況做出的測試環境)
//        when(articleService.saveArticle(articleObj)).thenReturn("Pass! status: 200"); //return a object

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .request(HttpMethod.POST, "/articles")
                        .contentType("application/json")
                        .content(article)

//                        模擬get請求
//                        .get("/user/{id}", userId);

//                        模擬Post請求
//                        .post("uri", parameters);

//                        模擬文件上傳
//                        .multipart("uri").file("fileName", "file".getBytes(StandardCharsets.UTF_8))

//                        模擬session和cookie
//                        .get("uri").sessionAttr("name", "value")
//                        .get("uri").cookie(new Cookie("name", "value"))
                )
                .andDo(print())
                .andReturn();

        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        log.info(mvcResult.getResponse().getContentAsString());
    }
}