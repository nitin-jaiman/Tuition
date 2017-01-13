package com.Services;

import com.Modal.CourseEntity;
import com.Repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by apple on 29/12/16.
 */
@Service
public class CourseService {



    @Autowired
    private CoursesRepository courseRepository;



    public List<CourseEntity> getCourses(Integer instituteId){


        List<CourseEntity> courseEntityList=new ArrayList<CourseEntity>();

        Iterator<CourseEntity> iterable=courseRepository.findByInstituteEntityInstituteId(instituteId).iterator();

        while(iterable.hasNext()){

            courseEntityList.add(iterable.next());

        }

        return courseEntityList;


    }

    public CourseEntity getCourseById(Integer courseId){


        return courseRepository.findOne(courseId);

    }


    public CourseEntity addCourse(CourseEntity courseEntity){





        return courseRepository.save(courseEntity);


    }

    public CourseEntity updateCourse(CourseEntity courseEntity){





        return courseRepository.save(courseEntity);


    }

    public void deleteCourse(CourseEntity courseEntity){





        courseRepository.delete(courseEntity);


    }




}
