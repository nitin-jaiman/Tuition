package com.Controller;

import com.Modal.StudentEntity;
import com.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * Created by apple on 07/01/17.
 */
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(method = {RequestMethod.POST}, value = "/validatelogin")
    private boolean saveStudent(@RequestParam("email") String email,@RequestParam("password") String password){


        System.out.println(email+"  "+password);


        return loginService.isValidLogin(email, password);


    }


}
