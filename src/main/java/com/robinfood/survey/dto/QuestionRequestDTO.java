package com.robinfood.survey.dto;

import java.util.List;

public class QuestionRequestDTO {

	private Long questionId;

	private List<Long> listAnswerId;

	public QuestionRequestDTO() {
		super();
	}

	public QuestionRequestDTO(Long questionId, List<Long> listAnswerId) {
		super();
		this.questionId = questionId;
		this.listAnswerId = listAnswerId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public List<Long> getListAnswerId() {
		return listAnswerId;
	}

	public void setListAnswerId(List<Long> listAnswerId) {
		this.listAnswerId = listAnswerId;
	}

}
