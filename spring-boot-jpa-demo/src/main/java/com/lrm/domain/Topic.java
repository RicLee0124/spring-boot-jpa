package com.lrm.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Topic {


    @Id
    @GeneratedValue
    private Long id;
    private String name;


    /**
     * topic和article是多对多的关系，双方都加入jointable，这样才都能够维护中间表，如果加上了mappedby属性，则被维护方被删除时，中间表的记录不会被删除
     */
    @ManyToMany
    @JoinTable(name = "topic_article",joinColumns = {@JoinColumn(name = "topics",referencedColumnName = "id")}
    ,inverseJoinColumns = {@JoinColumn(name = "articles",referencedColumnName = "id")})
    private List<Article> articles = new ArrayList<>();

    public Topic(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
