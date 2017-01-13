package com.Repository;

import com.Modal.CourseEntity;
import com.Modal.InstituteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by apple on 29/12/16.
 */
public interface CoursesRepository extends CrudRepository<CourseEntity,Integer> {

    public List<CourseEntity> findByInstituteEntityInstituteId(Integer userId);


}
