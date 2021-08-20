package com.goanna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InputVariablesServiceImpl implements InputVariablesService {
    @Autowired
    InputVariablesRepository inputVariablesRepository;

    @Override
    public List<InputVariables> getAllInputVariables() {
        List<InputVariables> inputVariables = new ArrayList<InputVariables>();
        inputVariablesRepository.findAll().forEach(inputVariable -> inputVariables.add(inputVariable));
        return inputVariables;
    }

    @Override
    public InputVariables getInputVariablesById(Long id) {
        return inputVariablesRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(InputVariables inputVariables) {
        inputVariablesRepository.save(inputVariables);
    }

    @Override
    public void delete(Long id) {
        inputVariablesRepository.deleteById(id);
    }

    @Override
    public double getBloodAlcoholContent(InputVariables inputVariables) {

        if (inputVariables.getGender().equalsIgnoreCase("Male")) {
            if(inputVariables.getWeight() > 0 && inputVariables.getHoursDrinking() > 0 &&
                inputVariables.getStandardDrinks() > 0) {
                return ((10 * inputVariables.getStandardDrinks()) - (7.5 * inputVariables.getHoursDrinking())) / (6.8 * inputVariables.getWeight());
            } else {
                return 0.0;
            }
        } else {
            return ((10 * inputVariables.getStandardDrinks()) - (7.5 * inputVariables.getHoursDrinking())) / (5.5 * inputVariables.getWeight());
        }
    }


}
