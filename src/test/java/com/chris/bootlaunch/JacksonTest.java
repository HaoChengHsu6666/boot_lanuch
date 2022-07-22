package com.chris.bootlaunch;

import com.chris.bootlaunch.model.ArticleVO;
import com.chris.bootlaunch.model.Reader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JacksonTest {

    @Test
    void testJackson() throws JsonProcessingException {

    //jackson的ObjectMapper 轉換物件
    ObjectMapper mapper = new ObjectMapper();

        List<Reader> readers = new ArrayList<Reader>(){{;
            add(new Reader("Chris", 21));
            add(new Reader("Judy", 22));
        }};

        //使用lombok提供的builder建構物件
        ArticleVO articleVO = ArticleVO.builder()
                .id(1L)
                .author("haha")
                .content("everyday")
                .createTime(new Date())
                .reader(readers)
                .title("You").build();

        //將Java的Object 轉換成 jackson的字串
        String jsonStr = mapper.writeValueAsString(articleVO);

        System.out.println(jsonStr);

        //將jackson的字串 轉換成 Java的Object
        ArticleVO articleVO1 = mapper.readValue(
                "{\n" +
                        "    \"author\": \"hsu\",\n" +
                        "    \"title\": \"QQQQ\",\n" +
                        "    \"content\": \"cccc\",\n" +
                        "    \"createTime\": \"2022/07/11 15:31:33\",\n" +
                        "    \"reader\": [{\"name\":\"hsu\",\"age\":15},{\"name\":\"hua\",\"age\":18}]\n" +
                        "}", ArticleVO.class);



        System.out.println(articleVO1);
    }
}
