package com.Services;

import com.Modal.TeacherEntity;
import com.Repository.TeachersRepository;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by apple on 03/01/17.
 */

@Service
public class TeacherService {

    @Autowired
    private TeachersRepository teacherRepository;



    public List<TeacherEntity> getTeachers(Integer instituteId){


        List<TeacherEntity> teacherEntityList=new ArrayList<TeacherEntity>();

        Iterator<TeacherEntity> iterable=teacherRepository.findByInstituteEntityInstituteId(instituteId).iterator();

        while(iterable.hasNext()){

            teacherEntityList.add(iterable.next());

        }


        return teacherEntityList;


    }

    public TeacherEntity getTeacherById(Integer teacherId){


        return teacherRepository.findOne(teacherId);

    }


    public TeacherEntity addTeacher(TeacherEntity teacherEntity){





        return teacherRepository.save(teacherEntity);


    }

    public TeacherEntity updateTeacher(TeacherEntity teacherEntity){





        return teacherRepository.save(teacherEntity);


    }

    public void deleteTeacher(TeacherEntity teacherEntity){





        teacherRepository.delete(teacherEntity);


    }


}
