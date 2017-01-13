package com.Repository;

import com.Modal.TeacherEntity;
import com.Modal.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by apple on 04/01/17.
 */
@Repository
public interface TestRepository extends JpaRepository<TeacherEntity, Long> {


    @Query(value = "select t.teacher_first_name as teacherFirstName,t.teacher_last_name as teacherLastName from teacher t where t.teacher_first_name like ?1 ",nativeQuery = true)
    public List<Object[]> findAllTeachers(String firstName);

}
