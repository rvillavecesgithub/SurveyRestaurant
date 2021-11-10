package com.robinfood.survey.dto;

import java.util.List;

import com.robinfood.survey.model.Answer;
import com.robinfood.survey.model.Question;

public class QuestionResponseDTO {

	private Question question;

	private List<Answer> answers;

	public QuestionResponseDTO() {
		super();
	}

	public QuestionResponseDTO(Question question, List<Answer> answers) {
		super();
		this.question = question;
		this.answers = answers;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
