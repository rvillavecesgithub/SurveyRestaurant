package com.robinfood.survey.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.robinfood.survey.model.SurveyQuestionAnswer;
import com.robinfood.survey.model.SurveyQuestionAnswerPK;
import com.robinfood.survey.repository.SurveyQuestionAnswerRepository;
import com.robinfood.survey.services.ISurveyQuestionAnswer;

@Component("surveyQuestionAnswer")
public class SurveyQuestionAnswerImpl implements ISurveyQuestionAnswer {

	@Autowired
	private SurveyQuestionAnswerRepository surveyQuestionAnswerRepository;

	@Override
	public SurveyQuestionAnswer findByIdSurveyQuestionAnswer(SurveyQuestionAnswerPK id) {
		return surveyQuestionAnswerRepository.findById(id).get();
	}

	@Override
	public List<SurveyQuestionAnswer> findAllSurveyQuestionAnswer() {
		return (List<SurveyQuestionAnswer>) surveyQuestionAnswerRepository.findAll();
	}

}
