package com.cj.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cj.spring.bean.User;
public interface UserRepository extends CrudRepository<User, Long>
{
	List<User> findByNameAndCountry(String name, String country);

}
