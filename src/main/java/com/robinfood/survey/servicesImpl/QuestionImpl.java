package com.robinfood.survey.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.robinfood.survey.model.Question;
import com.robinfood.survey.repository.QuestionRepository;
import com.robinfood.survey.services.IQuestion;

@Configuration
@Transactional
public class QuestionImpl implements IQuestion {

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Question findByIdQuestion(long id) {
		return questionRepository.findById(id).get();
	}

}
