package com.Controller;

import com.Modal.GradeEntity;
import com.Services.AuthService;
import com.Services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by apple on 03/01/17.
 */

@RestController
@RequestMapping(value = "/grades")
public class GradeController {


    @Autowired
    private GradeService gradeService;

   




    /*
    get all grades
     */
    @RequestMapping(method = {RequestMethod.GET})
    private ArrayList<GradeEntity> getGrades(){


        ArrayList<GradeEntity> gradeEntities=gradeService.getGradeEntities();
        if(gradeEntities.size()>0){

            for(GradeEntity gradeEntity:gradeEntities){

               // gradeEntity.add(linkTo(GradeController.class).slash(gradeEntity.getGradeId()).slash("institutes").withRel("institutes"));


            }

        }


        return gradeService.getGradeEntities();
    }


    /**
     * get grade by gradeId
     * @param gradeId
     * @return
     */
    @RequestMapping(method = {RequestMethod.GET},value = "/{gradeId}")
    private GradeEntity getGradeById(@PathVariable Integer gradeId){

        GradeEntity gradeEntity=   gradeService.getGradeById(gradeId);
        //gradeEntity.add(linkTo(GradeController.class).slash(gradeId).slash("institutes").withRel("institutes"));

        return gradeEntity;
    }



    @RequestMapping(method = {RequestMethod.POST})
    private GradeEntity saveGrade(@RequestBody GradeEntity gradeEntity){



        GradeEntity uEntity=gradeService.addGrade(gradeEntity);
       // uEntity.add(linkTo(GradeController.class).withSelfRel());
       // uEntity.add(linkTo(GradeController.class).slash("getcourses").withRel("courses"));


        return uEntity;


    }




    @RequestMapping(method = {RequestMethod.PUT})
    private GradeEntity updateGrade(@RequestBody GradeEntity gradeEntity,HttpServletResponse response){


        GradeEntity uEntity = gradeService.updateGrade(gradeEntity);
       // uEntity.add(linkTo(GradeController.class).withSelfRel());
       // uEntity.add(linkTo(GradeController.class).slash("getcourses").withRel("courses"));

        return uEntity;


    }






    @RequestMapping(method = {RequestMethod.DELETE})
    private void deleteGrade(@RequestBody GradeEntity gradeEntity, HttpServletResponse response){





        gradeService.deleteGrade(gradeEntity);


        response.addHeader("success","true");

    }


}
