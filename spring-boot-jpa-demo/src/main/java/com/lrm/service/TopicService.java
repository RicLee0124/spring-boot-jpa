package com.lrm.service;

import com.lrm.domain.Topic;

import java.util.Optional;

public interface TopicService {

    Topic saveTopic(Topic topic);

    Optional<Topic> findTopic(Long id);

    Topic findTopicWithEager(Long id);

    Topic updateTopic(Topic topic);

    Topic includeArticle(Long topicId,Long articleId);

    Topic unIncludeArticle(Long topicId,Long articleId);

    void deleteTopic(Long id);

}
