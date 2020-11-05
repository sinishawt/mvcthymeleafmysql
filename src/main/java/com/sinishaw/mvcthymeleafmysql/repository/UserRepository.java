package com.sinishaw.mvcthymeleafmysql.repository;

import com.sinishaw.mvcthymeleafmysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
