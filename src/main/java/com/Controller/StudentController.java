package com.Controller;

import com.Modal.StudentEntity;
import com.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by apple on 04/01/17.
 */
@RestController
public class StudentController {





    @Autowired
    private StudentService studentService;


    /**
     * get All students
     * @param userId
     * @return
     */
    @RequestMapping(method = {RequestMethod.GET} , value = "/users/{userId}/students")
    private List<StudentEntity> getStudents(@PathVariable Integer userId){




        List<StudentEntity> studentEntities=studentService.getStudents(userId);
        if(studentEntities.size()>0){

            for(StudentEntity studentEntity:studentEntities){

               // studentEntity.add(linkTo(StudentController.class).slash("/users/"+userId+"/students").slash(studentEntity.getStudentId()).slash("courses").withRel("courses"));


            }

        }


        return studentEntities;



    }


    /**
     * get student by id
     * @param userId
     * @param studentId
     * @return
     */
    @RequestMapping(method = {RequestMethod.GET} , value = "/users/{userId}/students/{studentId}")
    private StudentEntity getStudentById(@PathVariable Integer userId,@PathVariable Integer studentId){





        StudentEntity studentEntity=studentService.getStudentById(studentId);
       // studentEntity.add(linkTo(StudentController.class).slash("/users/"+userId+"/students").slash(studentEntity.getStudentId()).slash("courses").withRel("courses"));



        return studentEntity ;



    }




    @RequestMapping(method = {RequestMethod.POST}, value = "/users/{userId}/students")
    private StudentEntity saveStudent(@RequestBody StudentEntity studentEntity, @PathVariable Integer userId){



        StudentEntity iEntity=studentService.addStudent(studentEntity);
        //iEntity.add(linkTo(StudentController.class).slash("/users/"+userId+"/students").withSelfRel());
       // iEntity.add(linkTo(StudentController.class).slash("users").slash(userId).slash("students").slash(iEntity.getStudentId()).slash("courses").withRel("courses"));


        return iEntity;


    }


    @RequestMapping(method = {RequestMethod.PUT}, value = "/users/{userId}/students")
    private StudentEntity updateStudent(@RequestHeader(value="api") String apiKey, @RequestBody StudentEntity studentEntity, @PathVariable Integer userId){




        StudentEntity iEntity=studentService.updateStudent(studentEntity);
       // iEntity.add(linkTo(StudentController.class).slash("/users/"+userId+"/students").withSelfRel());
       // iEntity.add(linkTo(StudentController.class).slash("users").slash(userId).slash("students").slash(iEntity.getStudentId()).slash("courses").withRel("courses"));


        return iEntity;

    }





    @RequestMapping(method = {RequestMethod.DELETE}, value = "/users/{userId}/students")
    private void deleteStudent(@RequestBody StudentEntity StudentEntity, HttpServletResponse response){


        studentService.deleteStudent(StudentEntity);


    }


}
