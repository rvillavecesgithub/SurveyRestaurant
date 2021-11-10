package com.robinfood.survey.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.robinfood.survey.model.Answer;
import com.robinfood.survey.model.Survey;
import com.robinfood.survey.repository.AnswerRepository;
import com.robinfood.survey.repository.SurveyRepository;
import com.robinfood.survey.services.IAnswer;
import com.robinfood.survey.services.ISurvey;

@Configuration
@Transactional
public class AnswerImpl implements IAnswer {

	@Autowired
	private AnswerRepository answerRepository;


	@Override
	public Answer findByIdAnswer(long id) {
		return answerRepository.findById(id).get();
	}

}
