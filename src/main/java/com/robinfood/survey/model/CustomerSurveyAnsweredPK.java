/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robinfood.survey.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author rvill
 */
@Embeddable
public class CustomerSurveyAnsweredPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "SURVEY_QUESTION_ANSWER_ID")
	private SurveyQuestionAnswerPK surveyQuestionAnswerPk;
	@Basic(optional = false)
	@Column(name = "CUSTOMER_ID")
	private Long customer;
	@Basic(optional = false)
	@Column(name="DATE_CREATION",columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp dateCreation = new Timestamp(System.currentTimeMillis());

	public CustomerSurveyAnsweredPK() {
	}

	public CustomerSurveyAnsweredPK(SurveyQuestionAnswerPK surveyQuestionAnswerPk, Long customer) {
		super();
		this.surveyQuestionAnswerPk = surveyQuestionAnswerPk;
		this.customer = customer;
	}

	public Long getCustomer() {
		return customer;
	}

	public void setCustomer(Long customer) {
		this.customer = customer;
	}

	public SurveyQuestionAnswerPK getSurveyQuestionAnswerPk() {
		return surveyQuestionAnswerPk;
	}

	public void setSurveyQuestionAnswerPk(SurveyQuestionAnswerPK surveyQuestionAnswerPk) {
		this.surveyQuestionAnswerPk = surveyQuestionAnswerPk;
	}

	public Timestamp getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Timestamp dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	

}
