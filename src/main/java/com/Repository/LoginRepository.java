package com.Repository;

import com.Modal.TeacherEntity;
import com.Modal.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by apple on 07/01/17.
 */
public interface LoginRepository  extends JpaRepository<UserEntity, Integer> {


    @Query(value = "\n" +
            "select count(*) as count from user where user_email = ?1 AND user_phone=?2\n",nativeQuery = true)
    public List<BigInteger> isUserExist(String email, String phone);
}
