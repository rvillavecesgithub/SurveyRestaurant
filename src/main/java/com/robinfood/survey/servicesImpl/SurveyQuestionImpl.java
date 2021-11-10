package com.robinfood.survey.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.robinfood.survey.model.Survey;
import com.robinfood.survey.model.SurveyQuestion;
import com.robinfood.survey.model.SurveyQuestionPK;
import com.robinfood.survey.repository.SurveyQuestionRepository;
import com.robinfood.survey.repository.SurveyRepository;
import com.robinfood.survey.services.ISurvey;
import com.robinfood.survey.services.ISurveyQuestion;

@Configuration
@Transactional
public class SurveyQuestionImpl implements ISurveyQuestion {

	@Autowired
	private SurveyQuestionRepository surveyQuestionRepository;

	@Override
	public SurveyQuestion findByIdSurveyQuestion(SurveyQuestionPK id) {
		return surveyQuestionRepository.findById(id).get();
	}

}
