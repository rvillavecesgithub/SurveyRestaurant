package com.robinfood.survey.services;

import java.util.List;

import com.robinfood.survey.model.CustomerSurveyAnswered;
import com.robinfood.survey.model.SurveyQuestionPK;

public interface ICustomerSurveyAnswered{
    
	public List<CustomerSurveyAnswered> findAll();
	
	public CustomerSurveyAnswered saveCustomerSurveyAnswered(CustomerSurveyAnswered save);

}
