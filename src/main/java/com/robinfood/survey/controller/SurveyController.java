package com.robinfood.survey.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.robinfood.survey.bridge.BridgeImpl;
import com.robinfood.survey.dto.CustomerAnswerRequestDTO;
import com.robinfood.survey.dto.CustomerAnswerResponseDTO;
import com.robinfood.survey.dto.SurveyResponseDTO;
import com.robinfood.survey.facade.Facade;
import com.robinfood.survey.servicesImpl.CustomerSurveyAnswerImpl;
import com.robinfood.survey.servicesImpl.SurveyQuestionAnswerImpl;

@CrossOrigin(origins = "*")
@RestController
public class SurveyController {


	@GetMapping("/surveys")
	public List<SurveyResponseDTO> getAllSurvey() {
		Facade survey = new BridgeImpl(new SurveyQuestionAnswerImpl());
		return survey.findAllSurveyQuestionAnswer();
	}

	@GetMapping("/surveysAnswered")
	public List<CustomerAnswerResponseDTO> getSurveyAnswered() {
		Facade survey = new BridgeImpl(new CustomerSurveyAnswerImpl());
		return survey.findAllCustomerSurveyAnswered();
	}

	@PostMapping("/surveysAnswered")
	public ResponseEntity<?> saveCustomerSurveyAnswered(@RequestBody CustomerAnswerRequestDTO dto) {
		Facade survey = new BridgeImpl(new CustomerSurveyAnswerImpl());
		try {
			CustomerAnswerResponseDTO response = survey.saveCustomerSurveyAnswered(dto);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}catch (IllegalArgumentException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (JpaObjectRetrievalFailureException e) {
			return new ResponseEntity<>("Por favor revisar que los id concuerden por surveyId, questionId y answerId. Se deben asociar como se muestran en la encuesta.", HttpStatus.BAD_REQUEST);
		}catch (EntityNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	@GetMapping("/getSurveyById/{id}")
//	public ResponseEntity<?> getSurveyById(@PathVariable Long id) {
//		Facade survey = new BridgeImpl(new SurveyImpl());
//		try {
//			Survey s = survey.getSurveyById(id);
//			return new ResponseEntity<>(s, HttpStatus.OK);
//		} catch (NoSuchElementException e) {
//			return new ResponseEntity<>("No se encontro la encuesta con ese ID.", HttpStatus.BAD_REQUEST);
//		} catch (Exception e) {
//			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}


}
