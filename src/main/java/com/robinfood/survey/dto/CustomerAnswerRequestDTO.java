package com.robinfood.survey.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.robinfood.survey.model.Customer;

@JsonPropertyOrder(value = { "customer", "surveyId", "questionId", "answerId" }, alphabetic = false)
public class CustomerAnswerRequestDTO {

	private Customer customer;

	private SurveyRequestDTO surveyAnswer;

	public CustomerAnswerRequestDTO() {
		super();
	}

	public CustomerAnswerRequestDTO(Customer customer, SurveyRequestDTO surveyAnswer) {
		super();
		this.customer = customer;
		this.surveyAnswer = surveyAnswer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public SurveyRequestDTO getSurveyAnswer() {
		return surveyAnswer;
	}

	public void setSurveyAnswer(SurveyRequestDTO surveyAnswer) {
		this.surveyAnswer = surveyAnswer;
	}

}
