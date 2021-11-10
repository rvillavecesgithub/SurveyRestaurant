package com.robinfood.survey.repository;
import org.springframework.data.repository.CrudRepository;

import com.robinfood.survey.model.SurveyQuestionAnswer;
import com.robinfood.survey.model.SurveyQuestionAnswerPK;

public interface SurveyQuestionAnswerRepository extends CrudRepository<SurveyQuestionAnswer, SurveyQuestionAnswerPK> {

}