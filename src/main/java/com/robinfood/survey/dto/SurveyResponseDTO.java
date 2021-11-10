package com.robinfood.survey.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.robinfood.survey.model.Survey;

@JsonPropertyOrder(value = { "survey", "listQuestion"})
public class SurveyResponseDTO {

	@JsonProperty("survey")
	private Survey survey;

	@JsonProperty("listQuestion")
	private List<QuestionResponseDTO> listQuestion;

	
	public SurveyResponseDTO(Survey survey) {
		super();
		this.survey = survey;
	}

	public SurveyResponseDTO() {
		super();
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public List<QuestionResponseDTO> getListQuestion() {
		return listQuestion;
	}

	public void setListQuestion(List<QuestionResponseDTO> listQuestion) {
		this.listQuestion = listQuestion;
	}


}
