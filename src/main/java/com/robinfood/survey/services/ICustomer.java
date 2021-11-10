package com.robinfood.survey.services;

import java.util.List;

import com.robinfood.survey.model.Customer;
import com.robinfood.survey.model.CustomerSurveyAnswered;
import com.robinfood.survey.model.SurveyQuestionPK;

public interface ICustomer{
    
	public Customer findById(Long id);
	
	public  List<Customer>  findByFirstNameAndLastName(String firstName , String lastName);
	
	public List<Customer> findAll();
	
	public Customer saveCustomer(Customer save);

}
