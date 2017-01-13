package com.Controller;

import com.Modal.CourseEntity;
import com.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by apple on 29/12/16.
 */
@RestController
public class CoursesController {




    @Autowired
    private CourseService courseService;





    @RequestMapping(method = {RequestMethod.GET} , value = "/users/{userId}/institutes/{instituteId}/courses")
    private List<CourseEntity> getCourses(@PathVariable Integer userId,@PathVariable Integer instituteId){




        List<CourseEntity> courseEntities=courseService.getCourses(instituteId);
        if(courseEntities.size()>0){

            for(CourseEntity courseEntity:courseEntities){

              //  courseEntity.add(linkTo(CoursesController.class).slash("/users/"+userId+"/institutes").slash(courseEntity.getCourseId()).slash("courses").withRel("courses"));


            }

        }


        return courseEntities;



    }


    @RequestMapping(method = {RequestMethod.GET} , value = "/users/{userId}/institutes/{instituteId}/courses/{courseId}")
    private CourseEntity getCourseById(@PathVariable Integer userId,@PathVariable Integer courseId){





        CourseEntity courseEntity=courseService.getCourseById(courseId);
        //courseEntity.add(linkTo(CoursesController.class).slash("/users/"+userId+"/institutes").slash(courseEntity.getCourseId()).slash("courses").withRel("courses"));



        return courseEntity ;



    }




    @RequestMapping(method = {RequestMethod.POST}, value = "/users/{userId}/institutes/{instituteId}/courses")
    private CourseEntity saveCourse(@RequestBody CourseEntity CourseEntity){



        CourseEntity uEntity=courseService.addCourse(CourseEntity);
       // uEntity.add(linkTo(CoursesController.class).withSelfRel());
        //uEntity.add(linkTo(CoursesController.class).slash("getcourses").withRel("courses"));


        return uEntity;


    }


    @RequestMapping(method = {RequestMethod.PUT}, value = "/users/{userId}/institutes/{instituteId}/courses")
    private CourseEntity updateCourse(@RequestHeader(value="api") String apiKey, @RequestBody CourseEntity courseEntity){



        return courseService.updateCourse(courseEntity);


    }





    @RequestMapping(method = {RequestMethod.DELETE}, value = "/users/{userId}/institutes/{instituteId}/courses")
    private void deleteCourse(@RequestBody CourseEntity CourseEntity, HttpServletResponse response){


        courseService.deleteCourse(CourseEntity);


    }



}
