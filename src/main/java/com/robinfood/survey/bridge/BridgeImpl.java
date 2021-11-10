
package com.robinfood.survey.bridge;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.robinfood.survey.ApplicationContextHolder;
import com.robinfood.survey.dto.CustomerAnswerRequestDTO;
import com.robinfood.survey.dto.CustomerAnswerResponseDTO;
import com.robinfood.survey.dto.QuestionRequestDTO;
import com.robinfood.survey.dto.QuestionResponseDTO;
import com.robinfood.survey.dto.SurveyResponseDTO;
import com.robinfood.survey.model.Answer;
import com.robinfood.survey.model.Customer;
import com.robinfood.survey.model.CustomerSurveyAnswered;
import com.robinfood.survey.model.CustomerSurveyAnsweredPK;
import com.robinfood.survey.model.Question;
import com.robinfood.survey.model.Survey;
import com.robinfood.survey.model.SurveyQuestionAnswer;
import com.robinfood.survey.model.SurveyQuestionAnswerPK;
import com.robinfood.survey.model.SurveyQuestionPK;
import com.robinfood.survey.services.ICustomer;
import com.robinfood.survey.services.ICustomerSurveyAnswered;
import com.robinfood.survey.services.IQuestion;
import com.robinfood.survey.services.ISurvey;
import com.robinfood.survey.services.ISurveyQuestionAnswer;

public class BridgeImpl extends Bridge {

	private ISurvey iSurvey;

	private ISurveyQuestionAnswer iSurveyQuestionAnswer;

	private ICustomerSurveyAnswered iCustomerSurveyAnswered;

	private ICustomer iCustomer;

	private IQuestion iQuestion;

	public BridgeImpl() {

	}
	
	@Autowired
	public BridgeImpl(@Qualifier("survey") ISurvey servicio) {
		this.iSurvey = ApplicationContextHolder.getContext().getBean(servicio.getClass());
	}

	@Autowired
	public BridgeImpl(@Qualifier("surveyQuestionAnswer") ISurveyQuestionAnswer servicio) {
		this.iSurveyQuestionAnswer = ApplicationContextHolder.getContext().getBean(servicio.getClass());
	}

	@Autowired
	public BridgeImpl(@Qualifier("customerSurveyAnswered") ICustomerSurveyAnswered servicio) {
		this.iCustomerSurveyAnswered = ApplicationContextHolder.getContext().getBean(servicio.getClass());
	}

	@Override
	public Survey getSurveyById(Long surveyId) {
		Survey survey = this.iSurvey.findByIdSurvey(surveyId);
		return survey;
	}

	@Override
	public SurveyQuestionAnswer getSurveyQuestionAnswerById(SurveyQuestionAnswerPK surveyQuestionAnswerId) {
		SurveyQuestionAnswer surveyQuestionAnswer = this.iSurveyQuestionAnswer
				.findByIdSurveyQuestionAnswer(surveyQuestionAnswerId);
		return surveyQuestionAnswer;
	}

	@Override
	public List<SurveyResponseDTO> findAllSurveyQuestionAnswer() {
		List<SurveyQuestionAnswer> surveyQuestionAnswer = this.iSurveyQuestionAnswer.findAllSurveyQuestionAnswer();
		List<SurveyResponseDTO> listSurvey = convertEntitiesSurveyToDtoSurvey(surveyQuestionAnswer);
		return listSurvey;
	}

	private List<SurveyResponseDTO> convertEntitiesSurveyToDtoSurvey(List<SurveyQuestionAnswer> surveyQuestionAnswer) {
		List<SurveyResponseDTO> listSurvey = new ArrayList<SurveyResponseDTO>();
		List<SurveyQuestionAnswer> surveyQuestionAnswerTemp = new ArrayList<SurveyQuestionAnswer>();
		HashMap<Survey, List<SurveyQuestionAnswer>> mapSurveyQuestionAnswer = new HashMap<Survey, List<SurveyQuestionAnswer>>();
		for (SurveyQuestionAnswer surveyQuestionAnswerObj : surveyQuestionAnswer) {
			Survey skey = surveyQuestionAnswerObj.getSurveyQuestion().getSurvey();
			if (mapSurveyQuestionAnswer.containsKey(skey) && mapSurveyQuestionAnswer.get(skey) != null) {
				mapSurveyQuestionAnswer.get(skey).add(surveyQuestionAnswerObj);
			} else {
				surveyQuestionAnswerTemp.add(surveyQuestionAnswerObj);
				mapSurveyQuestionAnswer.put(skey, surveyQuestionAnswerTemp);
			}

		}
		for (Entry<Survey, List<SurveyQuestionAnswer>> surveyDTO : mapSurveyQuestionAnswer.entrySet()) {
			HashMap<Question, List<Answer>> mapQuestionAnswer = new HashMap<Question, List<Answer>>();
			SurveyResponseDTO dto = new SurveyResponseDTO();
			List<QuestionResponseDTO> listQuestion = new ArrayList<QuestionResponseDTO>();
			dto.setSurvey(surveyDTO.getKey());
			for (SurveyQuestionAnswer surveyDTO2 : surveyDTO.getValue()) {
				List<Answer> listAnswer = new ArrayList<Answer>();
				if (mapQuestionAnswer.containsKey(surveyDTO2.getSurveyQuestion().getQuestion())
						&& mapQuestionAnswer.get(surveyDTO2.getSurveyQuestion().getQuestion()) != null) {
					mapQuestionAnswer.get(surveyDTO2.getSurveyQuestion().getQuestion()).add(surveyDTO2.getAnswer());
				} else {
					listAnswer.add(surveyDTO2.getAnswer());
					mapQuestionAnswer.put(surveyDTO2.getSurveyQuestion().getQuestion(), listAnswer);
				}
			}
			System.out.println(mapQuestionAnswer);
			for (Entry<Question, List<Answer>> surveyDTO3 : mapQuestionAnswer.entrySet()) {
				QuestionResponseDTO qdto = new QuestionResponseDTO(surveyDTO3.getKey(), surveyDTO3.getValue());
				listQuestion.add(qdto);
			}
			dto.setListQuestion(listQuestion);
			listSurvey.add(dto);
		}
		return listSurvey;
	}

	@Override
	public List<CustomerAnswerResponseDTO> findAllCustomerSurveyAnswered() {
		List<CustomerAnswerResponseDTO> response = new ArrayList<CustomerAnswerResponseDTO>();
		HashMap<Long, List<CustomerSurveyAnswered>> map = new HashMap<Long, List<CustomerSurveyAnswered>>();
		HashMap<Long, HashMap<Customer, List<CustomerSurveyAnswered>>> map1 = new HashMap<Long, HashMap<Customer, List<CustomerSurveyAnswered>>>();
		List<CustomerSurveyAnswered> customerSurveyAnswereds = this.iCustomerSurveyAnswered.findAll();
		for (CustomerSurveyAnswered customerSurveyAnswered : customerSurveyAnswereds) {
			if (map.get(customerSurveyAnswered.getDateCreation().getTime()) != null
					&& map.containsKey(customerSurveyAnswered.getDateCreation().getTime())) {
				map.get(customerSurveyAnswered.getDateCreation().getTime()).add(customerSurveyAnswered);
			} else {
				List<CustomerSurveyAnswered> customerSurveyAnsweredTemp = new ArrayList<CustomerSurveyAnswered>();
				customerSurveyAnsweredTemp.add(customerSurveyAnswered);
				map.put(customerSurveyAnswered.getDateCreation().getTime(), customerSurveyAnsweredTemp);
			}
		}

		for (Entry<Long, List<CustomerSurveyAnswered>> customerSurveyAnswered : map.entrySet()) {
			for (CustomerSurveyAnswered customerSurveyAnswered2 : customerSurveyAnswered.getValue()) {
				if (map1.get(customerSurveyAnswered.getKey()) != null && map1.get(customerSurveyAnswered.getKey())
						.containsKey(customerSurveyAnswered2.getCustomer())) {
					map1.get(customerSurveyAnswered.getKey()).get(customerSurveyAnswered2.getCustomer())
							.add(customerSurveyAnswered2);
				} else {
					List<CustomerSurveyAnswered> customerSurveyAnsweredTemp2 = new ArrayList<CustomerSurveyAnswered>();
					customerSurveyAnsweredTemp2.add(customerSurveyAnswered2);
					HashMap<Customer, List<CustomerSurveyAnswered>> map3 = new HashMap<Customer, List<CustomerSurveyAnswered>>();
					map3.put(customerSurveyAnswered2.getCustomer(), customerSurveyAnsweredTemp2);
					map1.put(customerSurveyAnswered.getKey(), map3);
				}
			}
			for (Entry<Customer, List<CustomerSurveyAnswered>> customerSurveyAnswered2 : map1
					.get(customerSurveyAnswered.getKey()).entrySet()) {
				List<SurveyQuestionAnswer> srdto = new ArrayList<SurveyQuestionAnswer>();
				for (CustomerSurveyAnswered customerSurveyAnswered3 : customerSurveyAnswered2.getValue()) {
					srdto.add(customerSurveyAnswered3.getSurveyQuestionAnswer());
				}
				List<SurveyResponseDTO> srdto2 = convertEntitiesSurveyToDtoSurvey(srdto);
				CustomerAnswerResponseDTO cardto = new CustomerAnswerResponseDTO();
				SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss.S");
				cardto.setCreationDate(dt.format(new Timestamp(customerSurveyAnswered.getKey())));
				cardto.setCustomer(customerSurveyAnswered2.getKey());
				cardto.setSurveyAnswed(srdto2.get(0));
				response.add(cardto);
			}
		}
		return response;
	}

	@Override
	public CustomerAnswerResponseDTO saveCustomerSurveyAnswered(CustomerAnswerRequestDTO dto)
			throws IllegalArgumentException {
		this.iCustomer = ApplicationContextHolder.getContext().getBean(ICustomer.class);
		this.iQuestion = ApplicationContextHolder.getContext().getBean(IQuestion.class);
		Customer customer = new Customer();
		try {
			List<Customer> listCustomer = this.iCustomer.findByFirstNameAndLastName(dto.getCustomer().getFirstName(),
					dto.getCustomer().getLastName());
			customer = (Customer) (listCustomer != null && listCustomer.size() > 0 ? listCustomer.get(0) : null);
			if (!(customer != null && customer.getCustomerId() != null)) {
				customer = new Customer();
				customer.setCustomerId(customer.getCustomerId() != null && customer.getCustomerId() >= 0L ? null
						: customer.getCustomerId());
				customer = this.iCustomer.saveCustomer(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<SurveyQuestionAnswer> listsurveyQuestionAnswer = new ArrayList<SurveyQuestionAnswer>();
		String creationDate = new String();
		Timestamp t = new Timestamp(System.currentTimeMillis());
		for (QuestionRequestDTO questionId : dto.getSurveyAnswer().getListQuestionId()) {
			Question questionVal = this.iQuestion.findByIdQuestion(questionId.getQuestionId());
			SurveyQuestionPK sqpk = new SurveyQuestionPK(questionId.getQuestionId(), dto.getSurveyAnswer().getSurvey());
			if (questionId.getListAnswerId() != null && ((questionVal.getQuestionType().getQuestionTypeId() == 1L
					&& questionId.getListAnswerId().size() == 1)
					|| questionVal.getQuestionType().getQuestionTypeId() == 2L
							&& questionId.getListAnswerId().size() > 0)) {
				for (Long answerId : questionId.getListAnswerId()) {
					SurveyQuestionAnswerPK sqapk = new SurveyQuestionAnswerPK(sqpk, answerId);
					CustomerSurveyAnsweredPK csapk = new CustomerSurveyAnsweredPK(sqapk, customer.getCustomerId());
					csapk.setDateCreation(t);
					CustomerSurveyAnswered customerSurveyAnswereds = this.iCustomerSurveyAnswered
							.saveCustomerSurveyAnswered(new CustomerSurveyAnswered(csapk));
					SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss.S");
					creationDate = dt.format(customerSurveyAnswereds.getDateCreation());
					listsurveyQuestionAnswer.add(customerSurveyAnswereds.getSurveyQuestionAnswer());
				}
			} else {
				throw new IllegalArgumentException("La pregunta con ID : "
						+ (questionVal.getQuestionType().getQuestionTypeId()) + " con seleccion "
						+ questionVal.getQuestionType().getDescription()
						+ " no corresponde numero de respuesta enviadas que fueron "
						+ questionId.getListAnswerId().size() + " y deberian ser "
						+ (questionVal.getQuestionType().getQuestionTypeId() == 1L ? " 1 " : " igual o mayor de 1 "));
			}
		}
		List<SurveyResponseDTO> surveyresponse = convertEntitiesSurveyToDtoSurvey(listsurveyQuestionAnswer);
		CustomerAnswerResponseDTO response = new CustomerAnswerResponseDTO(customer, creationDate,
				surveyresponse.get(0));
		return response;
	}

}
