package com.robinfood.survey.services;

import javax.persistence.EntityNotFoundException;

import com.robinfood.survey.model.Question;


public interface IQuestion{
    
    public Question findByIdQuestion(long id) throws EntityNotFoundException;

}
