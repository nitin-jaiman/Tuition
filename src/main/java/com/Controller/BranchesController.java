package com.Controller;

import com.Modal.BranchEntity;
import com.Services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by apple on 31/12/16.
 */
@RestController
public class BranchesController {



    @Autowired
    private BranchService branchService;





    @RequestMapping(method = {RequestMethod.GET} , value = "/users/{userId}/institutes/{instituteId}/branches")
    private List<BranchEntity> getBranchs(@PathVariable Integer userId, @PathVariable Integer instituteId){




        List<BranchEntity> branchEntities=branchService.getBranches(instituteId);
        if(branchEntities.size()>0){

            for(BranchEntity branchEntity:branchEntities){

                //  branchEntity.add(linkTo(BranchsController.class).slash("/users/"+userId+"/institutes").slash(branchEntity.getBranchId()).slash("branchs").withRel("branchs"));


            }

        }


        return branchEntities;



    }


    @RequestMapping(method = {RequestMethod.GET} , value = "/users/{userId}/institutes/{instituteId}/branches/{branchId}")
    private BranchEntity getBranchById(@PathVariable Integer userId,@PathVariable Integer branchId){





        BranchEntity branchEntity=branchService.getBranchById(branchId);
        //branchEntity.add(linkTo(BranchsController.class).slash("/users/"+userId+"/institutes").slash(branchEntity.getBranchId()).slash("branchs").withRel("branchs"));



        return branchEntity ;



    }




    @RequestMapping(method = {RequestMethod.POST}, value = "/users/{userId}/institutes/{instituteId}/branches")
    private BranchEntity saveBranch(@RequestBody BranchEntity BranchEntity){



        BranchEntity uEntity=branchService.addBranch(BranchEntity);
        // uEntity.add(linkTo(BranchsController.class).withSelfRel());
        //uEntity.add(linkTo(BranchsController.class).slash("getbranchs").withRel("branchs"));


        return uEntity;


    }


    @RequestMapping(method = {RequestMethod.PUT}, value = "/users/{userId}/institutes/{instituteId}/branches")
    private BranchEntity updateBranch(@RequestHeader(value="api") String apiKey, @RequestBody BranchEntity branchEntity){



        return branchService.updateBranch(branchEntity);


    }





    @RequestMapping(method = {RequestMethod.DELETE}, value = "/users/{userId}/institutes/{instituteId}/branches")
    private void deleteBranch(@RequestBody BranchEntity BranchEntity, HttpServletResponse response){


        branchService.deleteBranch(BranchEntity);


    }




}
