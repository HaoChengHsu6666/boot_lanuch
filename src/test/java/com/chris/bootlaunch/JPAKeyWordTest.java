package com.chris.bootlaunch;

import com.chris.bootlaunch.dao.ArticleRepository;
import com.chris.bootlaunch.model.Article;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JPAKeyWordTest {

    @Resource
    private ArticleRepository articleRepository;

    @Test
    public void jpaTest(){
        Article article = articleRepository.findByAuthor("BigDick");
        System.out.println(article);
    }

}
