package com.Repository;


import com.Modal.Topic;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by apple on 25/12/16.
 */

public interface TopicRepository extends CrudRepository<Topic,Integer> {
}
