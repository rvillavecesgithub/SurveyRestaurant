package com.robinfood.survey.repository;

import org.springframework.data.repository.CrudRepository;

import com.robinfood.survey.model.CustomerSurveyAnswered;
import com.robinfood.survey.model.CustomerSurveyAnsweredPK;

public interface CustomerSurveyAnsweredRepository extends CrudRepository<CustomerSurveyAnswered, CustomerSurveyAnsweredPK>{

}
