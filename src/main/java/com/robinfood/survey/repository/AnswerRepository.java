package com.robinfood.survey.repository;
import org.springframework.data.repository.CrudRepository;

import com.robinfood.survey.model.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long> {

}