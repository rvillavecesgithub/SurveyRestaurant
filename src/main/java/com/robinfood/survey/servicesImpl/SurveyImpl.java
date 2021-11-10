package com.robinfood.survey.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.robinfood.survey.model.Survey;
import com.robinfood.survey.repository.SurveyRepository;
import com.robinfood.survey.services.ISurvey;

@Component("survey")
public class SurveyImpl implements ISurvey {

	@Autowired
	private SurveyRepository surveyRepository;

	@Override
	public Survey findByIdSurvey(long id) {
		return surveyRepository.findById(id).get();
	}

}
