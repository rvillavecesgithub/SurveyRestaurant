package com.robinfood.survey.repository;
import org.springframework.data.repository.CrudRepository;

import com.robinfood.survey.model.SurveyQuestion;
import com.robinfood.survey.model.SurveyQuestionPK;

public interface SurveyQuestionRepository extends CrudRepository<SurveyQuestion, SurveyQuestionPK> {

}