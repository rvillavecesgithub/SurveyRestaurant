package com.robinfood.survey.repository;
import org.springframework.data.repository.CrudRepository;

import com.robinfood.survey.model.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {

}