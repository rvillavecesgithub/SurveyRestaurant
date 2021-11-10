package com.robinfood.survey.services;

import com.robinfood.survey.model.SurveyQuestion;
import com.robinfood.survey.model.SurveyQuestionPK;


public interface ISurveyQuestion{
    
	public SurveyQuestion findByIdSurveyQuestion(SurveyQuestionPK id);

}
