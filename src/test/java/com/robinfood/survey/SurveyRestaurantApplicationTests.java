package com.robinfood.survey;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.robinfood.survey.bridge.BridgeImpl;
import com.robinfood.survey.controller.SurveyController;
import com.robinfood.survey.dto.CustomerAnswerRequestDTO;
import com.robinfood.survey.dto.CustomerAnswerResponseDTO;
import com.robinfood.survey.dto.QuestionRequestDTO;
import com.robinfood.survey.dto.SurveyRequestDTO;
import com.robinfood.survey.dto.SurveyResponseDTO;
import com.robinfood.survey.facade.Facade;
import com.robinfood.survey.model.Customer;
import com.robinfood.survey.repository.CustomerSurveyAnsweredRepository;
import com.robinfood.survey.servicesImpl.CustomerSurveyAnswerImpl;
import com.robinfood.survey.servicesImpl.SurveyQuestionAnswerImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class SurveyRestaurantApplicationTests {

	
	@InjectMocks
	private SurveyController principalController;

	@Autowired
	private CustomerSurveyAnsweredRepository customerSurveyAnsweredRepository;
	
	private CustomerAnswerRequestDTO requestDto;
	
	@BeforeEach
	void prepararData() {
		Customer c = new Customer("Cliente", "Prueba");
		List<QuestionRequestDTO> listQuestionId = new ArrayList<QuestionRequestDTO>();
		List<Long> listAnswerId = new ArrayList<Long>();
		listAnswerId.add(1L);
		QuestionRequestDTO qrDto = new QuestionRequestDTO(1L, listAnswerId);
		listQuestionId.add(qrDto);
		SurveyRequestDTO srDto = new SurveyRequestDTO(1L, listQuestionId);
		CustomerAnswerRequestDTO dto = new CustomerAnswerRequestDTO(c, srDto);
		requestDto= dto;
	}

	@Test
	void saveCustomerAnswered() {
		Facade survey = new BridgeImpl(new CustomerSurveyAnswerImpl());
		CustomerAnswerResponseDTO response = survey.saveCustomerSurveyAnswered(requestDto);
		assertThat(response).isNotNull();
	}

	@Test
	void saveCustomerAnsweredConroller() {
		ResponseEntity<CustomerAnswerResponseDTO> response = (ResponseEntity<CustomerAnswerResponseDTO>) principalController.saveCustomerSurveyAnswered(requestDto);
		assertThat(response).isNotNull();
	}
	
	@Test
	void getSurveyAnsweredConroller() {
		List<CustomerAnswerResponseDTO> response = principalController.getSurveyAnswered();
		assertThat(response).isNotNull();
	}
	
	@Test
	void getAllSurveyController() {
		Facade survey = new BridgeImpl(new SurveyQuestionAnswerImpl());
		List<SurveyResponseDTO> list =survey.findAllSurveyQuestionAnswer();
		assertThat(list).isNotNull();
	}

	
}
