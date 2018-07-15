package com.lrm.service;

import com.lrm.domain.Article;

import java.util.Optional;

public interface ArticleService {

    Article saveArticle(Article article);

    Article updateArticle(Article article);

    Optional<Article> findArticle(Long id);

    void deleteArticle(Long id);

}
