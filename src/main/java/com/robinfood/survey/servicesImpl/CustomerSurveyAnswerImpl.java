package com.robinfood.survey.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.robinfood.survey.model.CustomerSurveyAnswered;
import com.robinfood.survey.model.CustomerSurveyAnsweredPK;
import com.robinfood.survey.model.Survey;
import com.robinfood.survey.repository.CustomerSurveyAnsweredRepository;
import com.robinfood.survey.repository.SurveyRepository;
import com.robinfood.survey.services.ICustomerSurveyAnswered;
import com.robinfood.survey.services.ISurvey;

@Component("customerSurveyAnswer")
public class CustomerSurveyAnswerImpl implements ICustomerSurveyAnswered {

	@Autowired
	private CustomerSurveyAnsweredRepository customerSurveyAnsweredRepository;

	@Override
	public List<CustomerSurveyAnswered> findAll() {
		return (List<CustomerSurveyAnswered>) customerSurveyAnsweredRepository.findAll();
	}

	@Override
	public CustomerSurveyAnswered saveCustomerSurveyAnswered(CustomerSurveyAnswered save) {
		return customerSurveyAnsweredRepository.save(save);
	}

}
