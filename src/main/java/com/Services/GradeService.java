package com.Services;

import com.Modal.GradeEntity;
import com.Repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by apple on 03/01/17.
 */

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;




    public ArrayList<GradeEntity> getGradeEntities(){


        ArrayList<GradeEntity> gradeEntityList = loadGradeEntities();



        return gradeEntityList;


    }


    public GradeEntity addGrade(GradeEntity gradeEntity){


        GradeEntity uEntity=gradeRepository.save(gradeEntity);

     /*   AuthEntity authEntity=new AuthEntity();
        authEntity.setGradeEntity(uEntity);
        authEntity.setAuthIsValid((byte) 1);
        authEntity.setAuthKey(GenerateRandomString.getRandomString());


       AuthEntity aEntity= authRepository.save(authEntity);
       */

        return uEntity;

    }



    public GradeEntity updateGrade(GradeEntity gradeEntity){


        return gradeRepository.save(gradeEntity);

    }

    public void deleteGrade(GradeEntity gradeEntity){

        gradeRepository.delete(gradeEntity);

    }

    public GradeEntity getGradeById(Integer gradeId){


        return gradeRepository.findOne(gradeId);


    }


    private ArrayList<GradeEntity> loadGradeEntities() {
        ArrayList<GradeEntity> gradeEntityList=new ArrayList<GradeEntity>();

        Iterator<GradeEntity> iterable=gradeRepository.findAll().iterator();

        while(iterable.hasNext()){


            gradeEntityList.add(iterable.next());

        }
        return gradeEntityList;
    }





}
