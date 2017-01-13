package com.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by apple on 30/12/16.
 */
@Service
public class AuthService {
/*

    @Autowired
    private AuthRepository authRepository;



    public List<AuthEntity> getAuths(Integer userId){


        List<AuthEntity> authEntityList=new ArrayList<AuthEntity>();

        Iterator<AuthEntity> iterable=authRepository.findByUserEntityUserId(userId).iterator();

        while(iterable.hasNext()){

            authEntityList.add(iterable.next());

        }

        return authEntityList;


    }

    public AuthEntity getAuthById(Integer authId){


        return authRepository.findOne(authId);

    }


    public AuthEntity addAuth(AuthEntity authEntity){





        return authRepository.save(authEntity);


    }

    public AuthEntity updateAuth(AuthEntity authEntity){





        return authRepository.save(authEntity);


    }

    public void deleteAuth(AuthEntity authEntity){





        authRepository.delete(authEntity);


    }

    public Boolean isAuthKeyValid(String authKey){


      AuthEntity authEntity=  authRepository.findByAuthKey(authKey);

        if(authEntity!=null){

            if(authEntity.getAuthIsValid()!=null&&authEntity.getAuthIsValid()==(byte)1){


                return true;

            }else{

                return false;
            }

        }else{

            return false;

        }



    }

    */

}
