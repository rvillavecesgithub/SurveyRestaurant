/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robinfood.survey.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author rvill
 */
@Embeddable
public class SurveyQuestionAnswerPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "SURVEY_QUESTION_ID")
	private SurveyQuestionPK surveyQuestionPK;
	@Basic(optional = false)
	@Column(name = "ANSWER_ID")
	private Long answerId;

	public SurveyQuestionAnswerPK() {
	}

	public SurveyQuestionAnswerPK(SurveyQuestionPK surveyQuestionPK, Long answerId) {
		super();
		this.surveyQuestionPK = surveyQuestionPK;
		this.answerId = answerId;
	}

	public SurveyQuestionPK getSurveyQuestionPK() {
		return surveyQuestionPK;
	}

	public void setSurveyQuestionPK(SurveyQuestionPK surveyQuestionPK) {
		this.surveyQuestionPK = surveyQuestionPK;
	}

	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

}
