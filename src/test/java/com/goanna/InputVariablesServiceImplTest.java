package com.goanna;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputVariablesServiceImplTest {

    @Test
    void getAllInputVariables() {
    }

    @Test
    void getInputVariablesById() {
        InputVariables inputVariables = inputVariablesRepository.getInputVariablesById(1L);
        assertNotNull(inputVariables);
        InputVariables inputVariablesNotInDB = inputVariablesRepository.getInputVariablesById(999L);
        assertNull(inputVariablesNotInDB);
    }


    @Test
    void saveOrUpdate() {
    }

    @Test
    void delete() {
    }

    @Test
    void getBloodAlcoholContent() {
    }
}