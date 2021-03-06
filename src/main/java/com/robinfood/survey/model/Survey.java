package com.robinfood.survey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "surveys")
public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SURVEY_ID")
	private Long surveyId;
	private String name;


	public Survey() {

	}

	public Survey(Long surveyId, String name) {
		super();
		this.surveyId = surveyId;
		this.name = name;
	}

	public Survey(String name) {
		super();
		this.name = name;
	}

	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<Question> getQuestions() {
//		return questions;
//	}
//
//	public void setQuestions(List<Question> questions) {
//		this.questions = questions;
//	}

}
