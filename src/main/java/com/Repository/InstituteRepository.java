package com.Repository;

import com.Modal.InstituteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by apple on 27/12/16.
 */
public interface InstituteRepository  extends CrudRepository<InstituteEntity,Integer> {


    public List<InstituteEntity>  findByUserEntityUserId(Integer userId);

}
