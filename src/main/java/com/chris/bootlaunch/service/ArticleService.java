package com.chris.bootlaunch.service;

import com.chris.bootlaunch.model.ArticleVO;

import java.util.List;

public interface ArticleService {

    void saveArticle(ArticleVO articleVO);

    void deleteArticle(Long id);

    void updateArticle(ArticleVO articleVO);

    ArticleVO getArticle(Long id);

    List<ArticleVO> getAll();

}
