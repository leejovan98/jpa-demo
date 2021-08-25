package com.example.jpademo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.jpademo.data.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
