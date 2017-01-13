package com.Controller;

import com.Modal.InstituteEntity;
import com.Modal.Topic;
import com.Services.InstituteService;
import com.Services.TopicServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by apple on 24/12/16.
 */

@RestController
public class ControllerHi {


    @Autowired
   private InstituteService instituteService;

    @RequestMapping("/topics")
    public String sayHi(){

        ObjectMapper objectMapper = new ObjectMapper();
        //Set pretty printing of json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // String arrayToJson = objectMapper.writeValueAsString(instituteService.getInstitutes(1));

        return "";


    }


    @RequestMapping(method = {RequestMethod.POST},value = "/topics")
    public void addTopic(@RequestBody InstituteEntity instituteEntity){


         instituteService.addInstitute(instituteEntity);
    }



}
