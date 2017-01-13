package com.Services;

import com.Modal.InstituteEntity;
import com.Modal.Topic;
import com.Repository.InstituteRepository;
import com.Repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by apple on 27/12/16.
 */

@Service
public class InstituteService {




    @Autowired
    private InstituteRepository instituteRepository;



    public List<InstituteEntity> getInstitutes(Integer userId){


        List<InstituteEntity> instituteEntityList=new ArrayList<InstituteEntity>();

        Iterator<InstituteEntity> iterable=instituteRepository.findByUserEntityUserId(userId).iterator();

        while(iterable.hasNext()){

            instituteEntityList.add(iterable.next());

        }

        return instituteEntityList;


    }

    public InstituteEntity getInstituteById(Integer instituteId){


        return instituteRepository.findOne(instituteId);

    }


    public InstituteEntity addInstitute(InstituteEntity instituteEntity){





       return instituteRepository.save(instituteEntity);


    }

    public InstituteEntity updateInstitute(InstituteEntity instituteEntity){





       return instituteRepository.save(instituteEntity);


    }

    public void deleteInstitute(InstituteEntity instituteEntity){





        instituteRepository.delete(instituteEntity);


    }





}
