package com.Repository;

import com.Modal.BatchEntity;
import com.Modal.BranchEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by apple on 03/01/17.
 */
public interface BatchRepository extends CrudRepository<BatchEntity,Integer> {

    public List<BatchEntity> findByBranchEntityBranchId(Integer branchId);


}
