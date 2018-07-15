package com.lrm.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Article {


    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;


    @OneToMany(mappedBy = "article",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "topic_article",joinColumns = {@JoinColumn(name = "articles",referencedColumnName = "id")}
            ,inverseJoinColumns = {@JoinColumn(name = "topics",referencedColumnName = "id")})
    private List<Topic> topics = new ArrayList<>();

    public Article(){
    }

    public void addComment(Comment comment){
        comment.setArticle(this);
        comments.add(comment);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
