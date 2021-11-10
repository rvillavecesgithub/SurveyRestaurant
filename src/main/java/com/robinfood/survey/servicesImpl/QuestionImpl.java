package com.robinfood.survey.servicesImpl;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.robinfood.survey.model.Question;
import com.robinfood.survey.repository.QuestionRepository;
import com.robinfood.survey.services.IQuestion;

import javassist.NotFoundException;

@Configuration
@Transactional
public class QuestionImpl implements IQuestion {

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Question findByIdQuestion(long id) throws EntityNotFoundException{
		try {
			return questionRepository.findById(id).get();
		} catch (Exception e) {
			throw new EntityNotFoundException("La pregunta con id : "+id+" no esta asociado a la encuesta a diligenciar.");
		}
	}

}
