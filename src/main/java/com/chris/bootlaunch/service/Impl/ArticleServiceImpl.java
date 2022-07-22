package com.chris.bootlaunch.service.Impl;

import com.chris.bootlaunch.dao.ArticleJDBCDao;
import com.chris.bootlaunch.dao.ArticleRepository;
import com.chris.bootlaunch.model.Article;
import com.chris.bootlaunch.model.ArticleVO;
import com.chris.bootlaunch.service.ArticleService;
import com.chris.bootlaunch.utils.DozerUtils;
import org.dozer.Mapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    ArticleJDBCDao articleJDBCDao;

    @Resource
    ArticleRepository articleRepository;

    @Resource
    private Mapper dozerMapper;

    @Resource
    private JdbcTemplate primaryJdbcTemplate;
    @Resource
    private JdbcTemplate secondaryJdbcTemplate;

    @Override
    public void saveArticle(ArticleVO articleVO) {

        Article articlePO = dozerMapper.map(articleVO,Article.class);
        articleRepository.save(articlePO);

//        articleJDBCDao.save(articleVO,primaryJdbcTemplate);
//        articleJDBCDao.save(article,secondaryJdbcTemplate);
    }

    @Override
    public void deleteArticle(Long id) {
//        articleJDBCDao.deleteById(id,null);
        articleRepository.deleteById(id);
    }


    @Override
    @Transactional
    public void updateArticle(ArticleVO articleVO) {
//        if(articleVO.getId () == 0){
//            //article.id是必傳參數, 因為通常根據id去修改數據
//            //TODO 拋出一個自訂意異常
//        }
//        articleJDBCDao.deleteById(articleVO.getId(),null);
//        articleJDBCDao.save(articleVO,null);

        Article articlePO = dozerMapper.map(articleVO,Article.class);
        //更新一個物件到數據庫, 仍然使用save方法, 實際是根據articlePO.id去update
        articleRepository.save(articlePO);

    }

    @Override
    public ArticleVO getArticle(Long id) {
//        return articleJDBCDao.findById(id,null);

        //Optional為Java 8之語法，可檢查此數據是否為空
        Optional<Article> article = articleRepository.findById(id);
        //根據id查找到一條數據
        return dozerMapper.map(article.get(),ArticleVO.class);
    }

    @Override
    public List<ArticleVO> getAll() {
//        return articleJDBCDao.findAll(null);

        List<Article> articleList = articleRepository.findAll();
        //查詢article表裡的所以數據
        return DozerUtils.mapList(articleList,ArticleVO.class);

    }
}
