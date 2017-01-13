package com.Services;

import com.Modal.Topic;
import com.Repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by apple on 24/12/16.
 */

@Service
public class TopicServices {



    @Autowired
   private TopicRepository topicRepository;



    public List<Topic> getTopics(){


        List<Topic> topicList=new ArrayList<Topic>();

        Iterator<Topic> iterable=topicRepository.findAll().iterator();

        while(iterable.hasNext()){

            topicList.add(iterable.next());

        }

        return topicList;


    } public void addTopic(Topic topic){


        topicRepository.save(topic);


    }


}
