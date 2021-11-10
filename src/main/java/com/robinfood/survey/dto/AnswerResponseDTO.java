package com.robinfood.survey.dto;

import com.robinfood.survey.model.Answer;

public class AnswerResponseDTO {

	private Answer answer;

	public AnswerResponseDTO() {
		super();
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

}
