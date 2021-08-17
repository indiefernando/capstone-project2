package com.goanna;

import java.util.List;

public interface InputVariablesService {
        List<InputVariables> getAllVariables();
        void saveVariables(InputVariables inputVariables);
        InputVariables getGenderByInput(String gender);
    }

