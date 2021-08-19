package com.goanna.service;

import com.goanna.InputVariables;
import com.goanna.repository.InputVariablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface InputVariablesService {

    @Autowired
    InputVariablesRepository inputVariablesRepository;

    public default List<InputVariables> getAllVariables()
    {
        List<InputVariables> inputVariable = new ArrayList<InputVariables>();
        inputVariablesRepository.findAll().forEach(inputVariables -> inputVariable.add(inputVariables));
        return inputVariable;
    }

    public default InputVariables getVariablesById(int id)
    {
        return inputVariablesRepository.findById(id).get();
    }
    public default void saveOrUpdate(InputVariables inputVariables)
    {
        inputVariablesRepository.save(inputVariables);
    }

    public default void delete(int id)
    {
        inputVariablesRepository.deleteById(id);
    }
}


