package com.cj.spring.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.cj.spring.bean.*;
public interface AddressRepository extends CrudRepository<Address, Long>
{
	
}
