package com.robinfood.survey.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
@Table(name = "customers_surveys_answered")
public class CustomerSurveyAnswered {

	@EmbeddedId
	protected CustomerSurveyAnsweredPK customerSurveyAnsweredPK;

	@Basic(optional = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "ANSWER_ID", insertable = false, updatable = false),
			@JoinColumn(name = "QUESTION_ID", insertable = false, updatable = false),
			@JoinColumn(name = "SURVEY_ID", insertable = false, updatable = false)

	})
	private SurveyQuestionAnswer surveyQuestionAnswer;

	@JoinColumn(name = "CUSTOMER_ID", insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Customer customer;
	
	@NotNull
	@Column(name="DATE_CREATION", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	@Basic(optional = false)
	private Timestamp dateCreation;
	
	@Column(name="DESCRIPTION_QUESTION_OPEN")
	private String description;

	public CustomerSurveyAnswered() {
		super();
	}

	public CustomerSurveyAnswered(CustomerSurveyAnsweredPK customerSurveyAnsweredPK) {
		super();
		this.customerSurveyAnsweredPK = customerSurveyAnsweredPK;
		this.customer = new Customer();
		this.customer.setCustomerId(customerSurveyAnsweredPK.getCustomer());
		Answer idanswer = new  Answer(customerSurveyAnsweredPK.getSurveyQuestionAnswerPk().getAnswerId());
		SurveyQuestion sq = new SurveyQuestion(customerSurveyAnsweredPK.getSurveyQuestionAnswerPk().getSurveyQuestionPK());
		this.surveyQuestionAnswer = new SurveyQuestionAnswer(customerSurveyAnsweredPK.getSurveyQuestionAnswerPk(), sq, idanswer);
		this.dateCreation = new Timestamp(System.currentTimeMillis());
	}

	public CustomerSurveyAnswered(CustomerSurveyAnsweredPK customerSurveyAnsweredPK,
			SurveyQuestionAnswer surveyQuestionAnswer, Customer customer) {
		super();
		this.customerSurveyAnsweredPK = customerSurveyAnsweredPK;
		this.surveyQuestionAnswer = surveyQuestionAnswer;
		this.customer = customer;
	}

	public CustomerSurveyAnswered(CustomerSurveyAnsweredPK customerSurveyAnsweredPK,
			SurveyQuestionAnswerPK surveyQuestionAnswerpk, Customer customer) {
		super();
		this.customerSurveyAnsweredPK = customerSurveyAnsweredPK;
		this.surveyQuestionAnswer = new SurveyQuestionAnswer();
		this.surveyQuestionAnswer.setSurveyQuestionAnswerPK(surveyQuestionAnswerpk);
		this.customer = customer;
	}

	public SurveyQuestionAnswer getSurveyQuestionAnswer() {
		return surveyQuestionAnswer;
	}

	public void setSurveyQuestionAnswer(SurveyQuestionAnswer surveyQuestionAnswer) {
		this.surveyQuestionAnswer = surveyQuestionAnswer;
	}

	public CustomerSurveyAnsweredPK getCustomerSurveyAnsweredPK() {
		return customerSurveyAnsweredPK;
	}

	public void setCustomerSurveyAnsweredPK(CustomerSurveyAnsweredPK customerSurveyAnsweredPK) {
		this.customerSurveyAnsweredPK = customerSurveyAnsweredPK;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Timestamp getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Timestamp dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

//	public String getDateCreation() {
//		SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss.S");
//		return dt.format(this.dateCreation);
//	}
//
//	public void setDateCreation(Timestamp dateCreation) {
//		this.dateCreation = dateCreation;
//	}
	
	

	
	
	

}
