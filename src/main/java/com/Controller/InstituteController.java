package com.Controller;

import com.Modal.InstituteEntity;
import com.Services.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by apple on 29/12/16.
 */


@RestController
public class InstituteController {





    @Autowired
    private InstituteService instituteService;


    /**
     * get All institutes
     * @param userId
     * @return
     */
    @RequestMapping(method = {RequestMethod.GET} , value = "/users/{userId}/institutes")
    private List<InstituteEntity> getInstitutes(@PathVariable Integer userId){




        List<InstituteEntity> instituteEntities=instituteService.getInstitutes(userId);
        if(instituteEntities.size()>0){

            for(InstituteEntity instituteEntity:instituteEntities){

                instituteEntity.add(linkTo(InstituteController.class).slash("/users/"+userId+"/institutes").slash(instituteEntity.getInstituteId()).slash("courses").withRel("courses"));


            }

        }


        return instituteEntities;



    }


    /**
     * get institute by id
     * @param userId
     * @param instituteId
     * @return
     */
    @RequestMapping(method = {RequestMethod.GET} , value = "/users/{userId}/institutes/{instituteId}")
    private InstituteEntity getInstituteById(@PathVariable Integer userId,@PathVariable Integer instituteId){





        InstituteEntity instituteEntity=instituteService.getInstituteById(instituteId);
        instituteEntity.add(linkTo(InstituteController.class).slash("/users/"+userId+"/institutes").slash(instituteEntity.getInstituteId()).slash("courses").withRel("courses"));



        return instituteEntity ;



    }




    @RequestMapping(method = {RequestMethod.POST}, value = "/users/{userId}/institutes")
    private InstituteEntity saveInstitute(@RequestBody InstituteEntity instituteEntity,@PathVariable Integer userId){



        InstituteEntity iEntity=instituteService.addInstitute(instituteEntity);
        iEntity.add(linkTo(InstituteController.class).slash("/users/"+userId+"/institutes").withSelfRel());
        iEntity.add(linkTo(InstituteController.class).slash("users").slash(userId).slash("institutes").slash(iEntity.getInstituteId()).slash("courses").withRel("courses"));


        return iEntity;


    }


    @RequestMapping(method = {RequestMethod.PUT}, value = "/users/{userId}/institutes")
    private InstituteEntity updateInstitute(@RequestHeader(value="api") String apiKey, @RequestBody InstituteEntity instituteEntity, @PathVariable Integer userId){




        InstituteEntity iEntity=instituteService.updateInstitute(instituteEntity);
        iEntity.add(linkTo(InstituteController.class).slash("/users/"+userId+"/institutes").withSelfRel());
        iEntity.add(linkTo(InstituteController.class).slash("users").slash(userId).slash("institutes").slash(iEntity.getInstituteId()).slash("courses").withRel("courses"));


        return iEntity;

    }





    @RequestMapping(method = {RequestMethod.DELETE}, value = "/users/{userId}/institutes")
    private void deleteInstitute(@RequestBody InstituteEntity InstituteEntity, HttpServletResponse response){


        instituteService.deleteInstitute(InstituteEntity);


    }





}
