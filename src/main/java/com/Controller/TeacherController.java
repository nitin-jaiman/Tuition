package com.Controller;

import com.Modal.TeacherEntity;
import com.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by apple on 03/01/17.
 */

@RestController
public class TeacherController {



    @Autowired
    private TeacherService teacherService;





    @RequestMapping(method = {RequestMethod.GET} , value = "/users/{userId}/institutes/{instituteId}/teachers")
    private List<TeacherEntity> getTeachers(@PathVariable Integer userId, @PathVariable Integer instituteId){




        List<TeacherEntity> teacherEntities=teacherService.getTeachers(instituteId);
        if(teacherEntities.size()>0){

            for(TeacherEntity teacherEntity:teacherEntities){

                //  teacherEntity.add(linkTo(TeachersController.class).slash("/users/"+userId+"/institutes").slash(teacherEntity.getTeacherId()).slash("teachers").withRel("teachers"));


            }

        }


        return teacherEntities;



    }


    @RequestMapping(method = {RequestMethod.GET} , value = "/users/{userId}/institutes/{instituteId}/teachers/{teacherId}")
    private TeacherEntity getTeacherById(@PathVariable Integer userId,@PathVariable Integer teacherId){





        TeacherEntity teacherEntity=teacherService.getTeacherById(teacherId);
        //teacherEntity.add(linkTo(TeachersController.class).slash("/users/"+userId+"/institutes").slash(teacherEntity.getTeacherId()).slash("teachers").withRel("teachers"));



        return teacherEntity ;



    }




    @RequestMapping(method = {RequestMethod.POST}, value = "/users/{userId}/institutes/{instituteId}/teachers")
    private TeacherEntity saveTeacher(@RequestBody TeacherEntity TeacherEntity){



        TeacherEntity uEntity=teacherService.addTeacher(TeacherEntity);
        // uEntity.add(linkTo(TeachersController.class).withSelfRel());
        //uEntity.add(linkTo(TeachersController.class).slash("getteachers").withRel("teachers"));


        return uEntity;


    }


    @RequestMapping(method = {RequestMethod.PUT}, value = "/users/{userId}/institutes/{instituteId}/teachers")
    private TeacherEntity updateTeacher(@RequestHeader(value="api") String apiKey, @RequestBody TeacherEntity teacherEntity){



        return teacherService.updateTeacher(teacherEntity);


    }





    @RequestMapping(method = {RequestMethod.DELETE}, value = "/users/{userId}/institutes/{instituteId}/teachers")
    private void deleteTeacher(@RequestBody TeacherEntity TeacherEntity, HttpServletResponse response){


        teacherService.deleteTeacher(TeacherEntity);


    }




}
