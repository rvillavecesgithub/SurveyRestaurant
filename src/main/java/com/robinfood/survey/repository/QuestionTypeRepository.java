package com.robinfood.survey.repository;
import org.springframework.data.repository.CrudRepository;

import com.robinfood.survey.model.QuestionType;

public interface QuestionTypeRepository extends CrudRepository<QuestionType, Long> {

}