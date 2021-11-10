package com.robinfood.survey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QUESTION_ID")
	private Long questionId;
	private String description;
	@JoinColumn(name = "QUESTION_TYPE_ID")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private QuestionType questionType;

	public Question() {

	}

	public Question(String description) {
		this.description = description;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (questionId != null ? questionId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Question)) {
			return false;
		}
		Question other = (Question) object;
		if ((this.questionId == null && other.questionId != null)
				|| (this.questionId != null && !this.questionId.equals(other.questionId))) {
			return false;
		}
		return true;
	}

}
