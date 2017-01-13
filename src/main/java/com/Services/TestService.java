package com.Services;

import com.Modal.TeacherEntity;
import com.Modal.TestEntity;
import com.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by apple on 04/01/17.
 */
@Service
public class TestService {


    @Autowired
    public TestRepository testRepository;

    public List<Object[]> getTeachersFromCustomQuery(String firstName){



       return testRepository.findAllTeachers(firstName);


    }


}
