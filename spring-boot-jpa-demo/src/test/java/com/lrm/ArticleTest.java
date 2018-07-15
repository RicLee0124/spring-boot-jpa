package com.lrm;


import com.alibaba.fastjson.JSON;
import com.lrm.domain.Article;
import com.lrm.domain.Comment;
import com.lrm.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleTest {

    @Autowired
    private ArticleService articleService;



    @Test
    public void saveArticle(){
        Article article = new Article();
        article.setTitle("关于创业2");
        article.setContent("关于创业的一些想法2。。。");

        Comment comment1 = new Comment();
        comment1.setContent("评论3");
        Comment comment2 = new Comment();
        comment2.setContent("评论4");

        article.addComment(comment1);
        article.addComment(comment2);
        articleService.saveArticle(article);

    }


    @Test
    public void updateArticle(){
        Article article = articleService.findArticle(7l).get();
        article.setContent("游记：今天的所见所闻。。。。");
        articleService.updateArticle(article);
    }


    @Test
    public void findArticle(){
        Article article = articleService.findArticle(7l).get();
        System.out.println(JSON.toJSONString(article,true));
    }


    @Test
    public void deleteArticle(){
        articleService.deleteArticle(7l);
    }


}
