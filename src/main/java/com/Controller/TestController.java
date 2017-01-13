package com.Controller;

import com.Modal.TeacherEntity;
import com.Modal.TestEntity;
import com.Services.TestService;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 04/01/17.
 */

@RestController
public class TestController {


    @Autowired
    TestService testService;

    @RequestMapping(method = {RequestMethod.GET} , value = "/test1")
    private ArrayList<TestEntity> getTeachers(){


        List<Object[]> teacherEntities= testService.getTeachersFromCustomQuery("Arun");

        ArrayList<TestEntity> testEntities=new ArrayList<TestEntity>();

        for(Object[] employee: teacherEntities){

            TestEntity testEntity=new TestEntity();

            testEntity.setTeacherFirstName((String)employee[0]);
            testEntity.setTeacherLastName((String)employee[1]);

            testEntities.add(testEntity);

        }



        return testEntities;



    }

}
