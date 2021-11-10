package com.robinfood.survey.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.robinfood.survey.model.Customer;

@JsonPropertyOrder(value = { "creationDate", "customer", "surveyAnswed" }, alphabetic = false)
public class CustomerAnswerResponseDTO {

	private Customer customer;

	private String creationDate;

	private SurveyResponseDTO surveyAnswed;

	public CustomerAnswerResponseDTO() {
		super();
	}

	public CustomerAnswerResponseDTO(Customer customer, String creationDate, SurveyResponseDTO surveyAnswed) {
		super();
		this.customer = customer;
		this.creationDate = creationDate;
		this.surveyAnswed = surveyAnswed;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public SurveyResponseDTO getSurveyAnswed() {
		return surveyAnswed;
	}

	public void setSurveyAnswed(SurveyResponseDTO surveyAnswed) {
		this.surveyAnswed = surveyAnswed;
	}

}
