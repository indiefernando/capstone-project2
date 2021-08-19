package com.goanna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public interface InputVariablesService {



    public List<InputVariables> getAllInputVariables();

    //getting a specific record
    public InputVariables getInputVariablesById(Long id);

    public void saveOrUpdate(InputVariables inputVariables);

    //deleting a specific record
    public void delete(Long id);

    double getBloodAlcoholContent(InputVariables inputVariables);
}




