package com.Repository;

import com.Modal.AddressEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by apple on 03/01/17.
 */

public interface AddressRepository extends CrudRepository<AddressEntity,Integer> {
}
