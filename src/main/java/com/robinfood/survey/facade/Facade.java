
package com.robinfood.survey.facade;

import java.util.List;

import com.robinfood.survey.dto.CustomerAnswerRequestDTO;
import com.robinfood.survey.dto.CustomerAnswerResponseDTO;
import com.robinfood.survey.dto.SurveyResponseDTO;
import com.robinfood.survey.model.Survey;
import com.robinfood.survey.model.SurveyQuestionAnswer;
import com.robinfood.survey.model.SurveyQuestionAnswerPK;


public interface Facade {
    //Survey
	public Survey getSurveyById(Long surveyId);
	public SurveyQuestionAnswer getSurveyQuestionAnswerById(SurveyQuestionAnswerPK surveyQuestionAnswerId);
	public List<SurveyResponseDTO> findAllSurveyQuestionAnswer();
	
	public List<CustomerAnswerResponseDTO> findAllCustomerSurveyAnswered();
	public CustomerAnswerResponseDTO saveCustomerSurveyAnswered(CustomerAnswerRequestDTO dto)  throws IllegalArgumentException ;
	
	
}
