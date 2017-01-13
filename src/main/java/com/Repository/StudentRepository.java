package com.Repository;

import com.Modal.StudentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by apple on 04/01/17.
 */
public interface StudentRepository extends CrudRepository<StudentEntity,Integer> {

public List<StudentEntity> findByUserEntityUserId(Integer userId);

}
