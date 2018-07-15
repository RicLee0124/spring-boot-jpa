package com.lrm;


import com.alibaba.fastjson.JSON;
import com.lrm.domain.Article;
import com.lrm.domain.Topic;
import com.lrm.service.ArticleService;
import com.lrm.service.TopicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTest {

    @Autowired
    private TopicService topicService;

    @Autowired
    private ArticleService articleService;


    @Test
    public void saveTopic(){
        Topic topic = new Topic();
        topic.setName("艺术");
        topicService.saveTopic(topic);
    }


    @Test
    public void updateTopic(){
        Topic topic = topicService.findTopic(14l).get();
        topic.setName("文学");
        topicService.updateTopic(topic);
    }


    @Test
    public void includeArticle(){
        topicService.includeArticle(34l,31l);
    }

    @Transactional
    @Test
    public void findTopic(){
        Topic topic = topicService.findTopic(14l).get();
//        Topic topic = topicService.findTopicWithEager(14l);
        System.out.println(JSON.toJSONString(topic,true)); //如果不加上事物注解，则会抛出session关闭异常，高层级的事物会覆盖低层级的事物
    }


    @Test
    public void uncludeArticle(){
        topicService.unIncludeArticle(15l,25l);
    }


    @Test
    public void deleteTopic(){
        topicService.deleteTopic(15l); //关系的维护者，可以直接删除，中间表也会被自动删除
    }


    @Test
    public void deleteArticle(){
        articleService.deleteArticle(31l); //关系的被维护方，可以直接删除，但是中间表不会被删除
    }

}
