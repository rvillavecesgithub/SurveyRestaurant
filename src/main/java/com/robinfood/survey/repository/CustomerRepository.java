package com.robinfood.survey.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.robinfood.survey.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	public List<Customer> findByFirstName(String firstName);

}
