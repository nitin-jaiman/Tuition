package com.Services;

import com.Modal.StudentEntity;
import com.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by apple on 04/01/17.
 */
@Service
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;



    public List<StudentEntity> getStudents(Integer userId){


        List<StudentEntity> studentEntityList=new ArrayList<StudentEntity>();

        Iterator<StudentEntity> iterable=studentRepository.findByUserEntityUserId(userId).iterator();

        while(iterable.hasNext()){

            studentEntityList.add(iterable.next());

        }

        return studentEntityList;


    }

    public StudentEntity getStudentById(Integer studentId){


        return studentRepository.findOne(studentId);

    }


    public StudentEntity addStudent(StudentEntity studentEntity){





        return studentRepository.save(studentEntity);


    }

    public StudentEntity updateStudent(StudentEntity studentEntity){





        return studentRepository.save(studentEntity);


    }

    public void deleteStudent(StudentEntity studentEntity){





        studentRepository.delete(studentEntity);


    }



}
