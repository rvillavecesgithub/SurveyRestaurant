package com.robinfood.survey.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "surveys_questions_answers")
public class SurveyQuestionAnswer {

	@EmbeddedId
	@Column(name = "SURVEY_QUESTION_ANSWER_ID")
	protected SurveyQuestionAnswerPK surveyQuestionAnswerPK;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "QUESTION_ID", insertable = false, updatable = false),
			@JoinColumn(name = "SURVEY_ID", insertable = false, updatable = false) })
	private SurveyQuestion surveyQuestion;
	@JoinColumn(name = "ANSWER_ID", insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Answer answer;

	public SurveyQuestionAnswer() {

	}

	public SurveyQuestionAnswer(SurveyQuestionAnswerPK surveyQuestionAnswerPK, SurveyQuestion surveyQuestion,
			Answer answer) {
		super();
		this.surveyQuestionAnswerPK = surveyQuestionAnswerPK;
		this.surveyQuestion = surveyQuestion;
		this.answer = answer;
	}

	public SurveyQuestionAnswerPK getSurveyQuestionAnswerPK() {
		return surveyQuestionAnswerPK;
	}

	public void setSurveyQuestionAnswerPK(SurveyQuestionAnswerPK surveyQuestionAnswerPK) {
		this.surveyQuestionAnswerPK = surveyQuestionAnswerPK;
	}

	public SurveyQuestion getSurveyQuestion() {
		return surveyQuestion;
	}

	public void setSurveyQuestion(SurveyQuestion surveyQuestion) {
		this.surveyQuestion = surveyQuestion;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

}
