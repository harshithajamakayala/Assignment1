package com.nv.foodapp.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nv.foodapp.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{

	
}