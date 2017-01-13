package com.Repository;

import com.Modal.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by apple on 28/12/16.
 */
public interface UserRepository extends CrudRepository<UserEntity,Integer> {



}
