package com.chris.bootlaunch.dao;

import com.chris.bootlaunch.model.ArticleVO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ArticleJDBCDao {

    @Resource
//    private JdbcTemplate primaryjdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    //保存文章
    public void save(ArticleVO articleVO){
//        if (jdbcTemplate == null) {
//            jdbcTemplate = primaryjdbcTemplate;
//        }
        jdbcTemplate.update("INSERT INTO article(author, title, content, create_time) values (?, ?, ?, ?)",
            articleVO.getAuthor(),
            articleVO.getTitle(),
            articleVO.getContent(),
            articleVO.getCreateTime());
    }


    //刪除文章
    public void deleteById(Long id){
//        if (jdbcTemplate == null){
//            jdbcTemplate = primaryjdbcTemplate;
//        }
        //jdbcTemplate.update適合於insert、update及delete操作
        jdbcTemplate.update("DELETE FROM article WHERE id = ?",id);
    }

    //更新文章
    public void updateById(ArticleVO articleVO){
//        if (jdbcTemplate == null){
//            jdbcTemplate = primaryjdbcTemplate;
//        }
        //jdbcTemplate.update適合於insert、update及delete操作
        jdbcTemplate.update("UPDATE article SET author = ?,title = ?,content = ?, create_time = ? WHERE id = ?",
                articleVO.getAuthor(),
                articleVO.getTitle(),
                articleVO.getContent(),
                articleVO.getCreateTime(),
                articleVO.getId());
    }

    //根據id查詢一條紀錄
    public ArticleVO findById(Long id){
//        if (jdbcTemplate == null){
//            jdbcTemplate = primaryjdbcTemplate;
//        }
        return jdbcTemplate.queryForObject("SELECT * FROM article WHERE id = ?",new Object[]{id},
                new BeanPropertyRowMapper<>(ArticleVO.class));
    }

    //查詢所有紀錄
    public List<ArticleVO> findAll(){
//        if (jdbcTemplate == null){
//            jdbcTemplate = primaryjdbcTemplate;
//        }
        return (List<ArticleVO>) jdbcTemplate.query("SELECT * FROM article",
                new BeanPropertyRowMapper<>(ArticleVO.class));
    }
}

