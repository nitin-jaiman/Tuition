package com.Controller;

import com.Modal.UserEntity;
import com.Services.AuthService;
import com.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by apple on 28/12/16.
 */


@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;




/*
get all users
 */
    @RequestMapping(method = {RequestMethod.GET})
    private ArrayList<UserEntity> getUsers(){


        ArrayList<UserEntity> userEntities=userService.getUserEntities();
        if(userEntities.size()>0){

            for(UserEntity userEntity:userEntities){

                userEntity.add(linkTo(UserController.class).slash(userEntity.getUserId()).slash("institutes").withRel("institutes"));


            }

        }


        return userService.getUserEntities();
    }


    /**
     * get user by userId
     * @param userId
     * @return
     */
    @RequestMapping(method = {RequestMethod.GET},value = "/{userId}")
    private UserEntity getUserById(@PathVariable Integer userId){

        UserEntity userEntity=   userService.getUserById(userId);
        userEntity.add(linkTo(UserController.class).slash(userId).slash("institutes").withRel("institutes"));

        return userEntity;
    }



    @RequestMapping(method = {RequestMethod.POST})
    private UserEntity saveUser(@RequestBody UserEntity userEntity){



        UserEntity uEntity=userService.addUser(userEntity);
        uEntity.add(linkTo(UserController.class).withSelfRel());
        uEntity.add(linkTo(UserController.class).slash("getcourses").withRel("courses"));


        return uEntity;


}




    @RequestMapping(method = {RequestMethod.PUT})
    private UserEntity updateUser(@RequestBody UserEntity userEntity,HttpServletResponse response){


            UserEntity uEntity = userService.updateUser(userEntity);
            uEntity.add(linkTo(UserController.class).withSelfRel());
            uEntity.add(linkTo(UserController.class).slash("getcourses").withRel("courses"));

        return uEntity;


    }






    @RequestMapping(method = {RequestMethod.DELETE})
    private void deleteUser(@RequestBody UserEntity userEntity, HttpServletResponse response){





         userService.deleteUser(userEntity);


       response.addHeader("success","true");

    }


}
