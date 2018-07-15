package com.lrm.service;

import com.lrm.domain.Article;
import com.lrm.domain.ArticleRepository;
import com.lrm.domain.Topic;
import com.lrm.domain.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    public Optional<Topic> findTopic(Long id) {
        return topicRepository.findById(id);
    }

    @Transactional
    @Override
    public Topic findTopicWithEager(Long id) {
        Optional<Topic> opt = topicRepository.findById(id);
        if(opt.isPresent()){
            Topic topic = opt.get();
            topic.getArticles();
            return topic;
        }
        return null;
    }

    @Transactional
    @Override
    public Topic updateTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Transactional
    @Override
    public Topic includeArticle(Long topicId, Long articleId) {
        Optional<Topic> toOpt = topicRepository.findById(topicId);
        Optional<Article> arOpt = articleRepository.findById(articleId);
        Topic topic = toOpt.get();
        Article article = arOpt.get();
        topic.getArticles().add(article);
        return topic; // 事物提交会自动保存
    }

    @Transactional
    @Override
    public Topic unIncludeArticle(Long topicId, Long articleId) {
        Optional<Topic> toOpt = topicRepository.findById(topicId);
        Optional<Article> arOpt = articleRepository.findById(articleId);
        Topic topic = toOpt.get();
        Article article = arOpt.get();
        topic.getArticles().remove(article);
        return topic;
    }

    @Transactional
    @Override
    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}
