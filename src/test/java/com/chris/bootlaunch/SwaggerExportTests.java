//package com.chris.bootlaunch;
//
//import io.github.swagger2markup.GroupBy;
//import io.github.swagger2markup.Language;
//import io.github.swagger2markup.Swagger2MarkupConfig;
//import io.github.swagger2markup.Swagger2MarkupConverter;
//import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
//import io.github.swagger2markup.markup.builder.MarkupLanguage;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.net.URL;
//import java.nio.file.Paths;
//
////@@@@@@@@@@@@@@@@@@@@@@@@@@@ 測試失敗 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//
//
//@ExtendWith(SpringExtension.class)
////@RunWith(SpringRunner.class) //JUnit4開發者使用這個註解
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//public class SwaggerExportTests {
//
//    @Test
//    public void generateAsciiDocs() throws  Exception {
//
//        //輸出Ascii格式
//        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
//                .withMarkupLanguage(MarkupLanguage.ASCIIDOC) //設置生成格式
//                .withOutputLanguage(Language.ZH) //設置語言中文還是其他語言
//                .withPathsGroupedBy(GroupBy.TAGS) //預設一個Controller當一個tags
//                .withGeneratedExamples()
//                .withoutInlineSchema()
//                .build();
//
//        Swagger2MarkupConverter.from(new URL("http://localhost:8888/v2/api-docs"))
//                .withConfig(config)
//                .build()
//                .toFile(Paths.get("src/main/resources/docs/asciidoc"));
//
//    }
//
//
//}
