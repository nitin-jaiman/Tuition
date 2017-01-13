package com.Services;

import com.Modal.UserEntity;
import com.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by apple on 28/12/16.
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;




    public ArrayList<UserEntity> getUserEntities(){


        ArrayList<UserEntity> userEntityList = loadUserEntities();



        return userEntityList;


    }


    public UserEntity addUser(UserEntity userEntity){


        UserEntity uEntity=userRepository.save(userEntity);

     /*   AuthEntity authEntity=new AuthEntity();
        authEntity.setUserEntity(uEntity);
        authEntity.setAuthIsValid((byte) 1);
        authEntity.setAuthKey(GenerateRandomString.getRandomString());


       AuthEntity aEntity= authRepository.save(authEntity);
       */

        return uEntity;

    }



    public UserEntity updateUser(UserEntity userEntity){


        return userRepository.save(userEntity);

    }

    public void deleteUser(UserEntity userEntity){

        userRepository.delete(userEntity);

    }

    public UserEntity getUserById(Integer userId){


        return userRepository.findOne(userId);


    }


    private ArrayList<UserEntity> loadUserEntities() {
        ArrayList<UserEntity> userEntityList=new ArrayList<UserEntity>();

        Iterator<UserEntity> iterable=userRepository.findAll().iterator();

        while(iterable.hasNext()){


            userEntityList.add(iterable.next());

        }
        return userEntityList;
    }




}
