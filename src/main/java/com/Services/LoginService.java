package com.Services;

import com.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by apple on 07/01/17.
 */
@Service
public class LoginService {


    @Autowired
    LoginRepository loginRepository;




    public boolean isValidLogin(String emailOrPhone,String password){

      List<BigInteger> o= loginRepository.isUserExist(emailOrPhone,password);

        if(((BigInteger)o.get(0)).intValue()>0){

            return true;
        }else{

            return false;
        }


    }





}
