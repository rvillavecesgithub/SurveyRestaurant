package com.robinfood.survey.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "surveys_questions")
public class SurveyQuestion {

	@EmbeddedId
	@Column(name = "SURVEY_QUESTION_ID")
	protected SurveyQuestionPK surveyAnswerPK;
	@JoinColumn(name = "SURVEY_ID", insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Survey survey;
	@JoinColumn(name = "QUESTION_ID", insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Question question;

	public SurveyQuestion() {

	}

	public SurveyQuestion(SurveyQuestionPK surveyAnswerPK) {
		super();
		this.surveyAnswerPK = surveyAnswerPK;
	}

	public SurveyQuestion(SurveyQuestionPK surveyAnswerPK, Survey survey, Question question) {
		super();
		this.surveyAnswerPK = surveyAnswerPK;
		this.survey = survey;
		this.question = question;
	}

	public SurveyQuestionPK getSurveyAnswerPK() {
		return surveyAnswerPK;
	}

	public void setSurveyAnswerPK(SurveyQuestionPK surveyAnswerPK) {
		this.surveyAnswerPK = surveyAnswerPK;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}
