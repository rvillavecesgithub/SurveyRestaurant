package com.robinfood.survey.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.robinfood.survey.model.Customer;
import com.robinfood.survey.repository.CustomerRepository;
import com.robinfood.survey.services.ICustomer;

@Configuration
@Transactional
public class CustomerImpl implements ICustomer {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll() {
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public Customer saveCustomer(Customer save) {
		return customerRepository.save(save);
	}

	@Override
	public Customer findById(Long id) {
		return customerRepository.findById(id).get();
	}

	@Override
	public List<Customer> findByFirstNameAndLastName(String firstName, String lastName) {
		List<Customer> list =  customerRepository.findByFirstName(firstName);
		return list;
	}

}
