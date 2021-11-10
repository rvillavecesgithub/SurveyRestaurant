package com.robinfood.survey.services;

import com.robinfood.survey.model.Question;


public interface IQuestion{
    
    public Question findByIdQuestion(long id);

}
