package com.chris.bootlaunch.Controller;

import com.chris.bootlaunch.AjaxResponse;
import com.chris.bootlaunch.model.ArticleVO;
import com.chris.bootlaunch.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
//加這段須搭配回傳註解 @ResponseBody
@Controller
//@RestController
@RequestMapping("/rest")
public class ArticleController {

    @Resource
    ArticleService articleService;

//    @RequestMapping(value = "/articles/{id}", method = RequestMethod.GET)
    @GetMapping("/articles/{id}")
    public @ResponseBody AjaxResponse getArticle(@PathVariable Long id) {

//        List<Reader> readers = new ArrayList<Reader>(){{;
//        add(new Reader("Chris", 21));
//        add(new Reader("Judy", 22));
//        }};
//
//        //使用lombok提供的builder建構物件
//        Article article = Article.builder()
//                .id(1L)
//                .author("R_hsu")
//                .content("KeepLearning")
//                .createTime(new Date())
//                .reader(readers)
//                .title("青銅到王者開發Springboot").build();

        ArticleVO articleVO = articleService.getArticle(id);
        log.info("article: " + articleVO);
        return AjaxResponse.success(articleVO);
    }

    @GetMapping("/articles")
    public @ResponseBody AjaxResponse getArticle() {

        List<ArticleVO> articleVOS = articleService.getAll();
        log.info("article: " + articleVOS);
        return AjaxResponse.success(articleVOS);
    }




//    @RequestMapping(value = "/articles", method = RequestMethod.POST)
    @PostMapping("/articles")
    public @ResponseBody AjaxResponse saveArticle(@RequestBody ArticleVO articleVO) {
        //無物件
//        return AjaxResponse.success();
        //有物件(MockMVC)(Test測試用)
//          return AjaxResponse.success(article);
        //有物件(Mokito)(Test3測試用)
//        return AjaxResponse.success(articleService.saveArticle(article));


//    @RequestMapping(value = "/articles", method = RequestMethod.POST)
//    @PostMapping("/articles2")
//    public AjaxResponse saveArticle(@RequestParam   String author,
//                                    @RequestParam   String title,
//                                    @RequestParam   String content,
//                                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//                                    @RequestParam   Date createTime) {

        articleService.saveArticle(articleVO);
        log.info("saveArticle: " + articleVO);
        return AjaxResponse.success();
    }



//    @RequestMapping(value = "/articles", method = RequestMethod.PUT)
    @PutMapping("/articles")
    public @ResponseBody AjaxResponse updateArticle(@RequestBody ArticleVO articleVO) {

        articleService.updateArticle(articleVO);
        log.info("updateArticel: " + articleVO);
        return AjaxResponse.success();
    }

//    @RequestMapping(value = "/articles/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/articles/{id}")
    public @ResponseBody AjaxResponse deleteArticle(@PathVariable ("id") Long id) {

        articleService.deleteArticle(id);
        log.info("deleteArticel: " + id);
        return AjaxResponse.success();
    }

}
