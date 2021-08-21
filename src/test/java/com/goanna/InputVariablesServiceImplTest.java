package com.goanna;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InputVariablesServiceImplTest {

    @Autowired
    private InputVariablesService inputVariablesService;

    @Test
    void getInputVariablesById() {
        InputVariables inputVariables = inputVariablesService.getInputVariablesById(34L);
        assertNotNull(inputVariables);
        InputVariables inputVariablesNotInDB = inputVariablesService.getInputVariablesById(999L);
        assertNull(inputVariablesNotInDB);
    }

    @Test
    void getBloodAlcoholContentWithZeroWeight() {
        String gender = "Female";
        double weight = 0;
        double standardDrinks = 2.0;
        double hoursDrinking = 1.0;

        InputVariables input = new InputVariables();
        input.setHoursDrinking(hoursDrinking);
        input.setWeight(weight);
        input.setGender(gender);
        input.setStandardDrinks(standardDrinks);

        double bloodAlcoholContent = inputVariablesService.getBloodAlcoholContent(input);

        assertEquals(Double.POSITIVE_INFINITY, bloodAlcoholContent);
    }
}