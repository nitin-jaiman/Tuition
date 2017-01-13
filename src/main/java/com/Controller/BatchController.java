package com.Controller;

import com.Modal.BatchEntity;
import com.Services.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by apple on 03/01/17.
 */
@RestController
public class BatchController {


    @Autowired
    private BatchService batchService;





    @RequestMapping(method = {RequestMethod.GET} , value = "/users/{userId}/institutes/{instituteId}/branches/{branchId}/batches")
    private List<BatchEntity> getBatchs(@PathVariable Integer userId, @PathVariable Integer instituteId, @PathVariable Integer branchId){




        List<BatchEntity> batchEntities=batchService.getBatches(branchId);
        if(batchEntities.size()>0){

            for(BatchEntity batchEntity:batchEntities){

                //  batchEntity.add(linkTo(BatchsController.class).slash("/users/"+userId+"/institutes").slash(batchEntity.getBatchId()).slash("batchs").withRel("batchs"));


            }

        }


        return batchEntities;



    }


    @RequestMapping(method = {RequestMethod.GET} , value = "/users/{userId}/institutes/{instituteId}/branches/{branchId}/batches/{batchId}")
    private BatchEntity getBatchById(@PathVariable Integer userId,@PathVariable Integer batchId,@PathVariable Integer branchId){





        BatchEntity batchEntity=batchService.getBatchById(batchId);
        //batchEntity.add(linkTo(BatchsController.class).slash("/users/"+userId+"/institutes").slash(batchEntity.getBatchId()).slash("batchs").withRel("batchs"));



        return batchEntity ;



    }




    @RequestMapping(method = {RequestMethod.POST}, value = "/users/{userId}/institutes/{instituteId}/branches/{branchId}/batches")
    private BatchEntity saveBatch(@RequestBody BatchEntity BatchEntity){



        BatchEntity uEntity=batchService.addBatch(BatchEntity);
        // uEntity.add(linkTo(BatchsController.class).withSelfRel());
        //uEntity.add(linkTo(BatchsController.class).slash("getbatchs").withRel("batchs"));


        return uEntity;


    }


    @RequestMapping(method = {RequestMethod.PUT}, value = "/users/{userId}/institutes/{instituteId}/branches/{branchId}/batches")
    private BatchEntity updateBatch(@RequestHeader(value="api") String apiKey, @RequestBody BatchEntity batchEntity){



        return batchService.updateBatch(batchEntity);


    }





    @RequestMapping(method = {RequestMethod.DELETE}, value = "/users/{userId}/institutes/{instituteId}/branches/{branchId}/batches")
    private void deleteBatch(@RequestBody BatchEntity BatchEntity, HttpServletResponse response){


        batchService.deleteBatch(BatchEntity);


    }



}
