package com.Repository;

import com.Modal.CourseEntity;
import com.Modal.TeacherEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by apple on 03/01/17.
 */
public interface TeachersRepository extends CrudRepository<TeacherEntity,Integer> {

    public List<TeacherEntity> findByInstituteEntityInstituteId(Integer userId);


}
