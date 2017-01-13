package com.Repository;

import com.Modal.BranchEntity;
import com.Modal.CourseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by apple on 31/12/16.
 */
public interface BranchRepository extends CrudRepository<BranchEntity,Integer> {

    public List<BranchEntity> findByInstituteEntityInstituteId(Integer userId);

}
