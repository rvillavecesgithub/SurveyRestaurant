package com.robinfood.survey.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(value = { "survey", "listQuestion" })
public class SurveyRequestDTO {

	@JsonProperty("survey")
	private Long survey;

	@JsonProperty("listQuestionId")
	private List<QuestionRequestDTO> listQuestionId;

	public SurveyRequestDTO() {
		super();
	}

	public SurveyRequestDTO(Long survey, List<QuestionRequestDTO> listQuestionId) {
		super();
		this.survey = survey;
		this.listQuestionId = listQuestionId;
	}

	public Long getSurvey() {
		return survey;
	}

	public void setSurvey(Long survey) {
		this.survey = survey;
	}

	public List<QuestionRequestDTO> getListQuestionId() {
		return listQuestionId;
	}

	public void setListQuestionId(List<QuestionRequestDTO> listQuestionId) {
		this.listQuestionId = listQuestionId;
	}

}
