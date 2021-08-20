package com.goanna;

import java.util.List;

public interface InputVariablesService {

    public List<InputVariables> getAllInputVariables();

    public InputVariables getInputVariablesById(Long id);

    public void saveOrUpdate(InputVariables inputVariables);

    public void delete(Long id);

    double getBloodAlcoholContent(InputVariables inputVariables);
}




