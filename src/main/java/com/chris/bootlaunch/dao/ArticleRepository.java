package com.chris.bootlaunch.dao;

import com.chris.bootlaunch.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    //特別注意此方法的名稱，JPA會根據方法名自動生成SQL執行
    //等同於此段SQL (SELECT * FROM article WHERE author = ?)
    Article findByAuthor(String auther);
}
