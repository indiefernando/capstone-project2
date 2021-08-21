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


}