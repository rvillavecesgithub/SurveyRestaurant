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
//import javax.validation.constraints.NotNull;

/**
 *
 * @author rvill
 */
@Embeddable
public class SurveyQuestionPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
//	@NotNull
	@Column(name = "SURVEY_ID")
	private long surveyId;
	@Basic(optional = false)
//	@NotNull
	@Column(name = "QUESTION_ID")
	private long questionId;
	

	public SurveyQuestionPK() {
	}

	public SurveyQuestionPK(long questionId, long surveyId) {
		super();
		this.questionId = questionId;
		this.surveyId = surveyId;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(long surveyId) {
		this.surveyId = surveyId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (int) questionId;
		hash += (int) surveyId;
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof SurveyQuestionPK)) {
			return false;
		}
		SurveyQuestionPK other = (SurveyQuestionPK) object;
		if (this.questionId != other.questionId) {
			return false;
		}
		if (this.surveyId != other.surveyId) {
			return false;
		}
		return true;
	}

}
