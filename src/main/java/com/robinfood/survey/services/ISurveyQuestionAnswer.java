package com.robinfood.survey.services;

import java.util.List;

import com.robinfood.survey.model.SurveyQuestionAnswer;
import com.robinfood.survey.model.SurveyQuestionAnswerPK;


public interface ISurveyQuestionAnswer{
    
	public SurveyQuestionAnswer findByIdSurveyQuestionAnswer(SurveyQuestionAnswerPK id);
	public List<SurveyQuestionAnswer> findAllSurveyQuestionAnswer();

}
