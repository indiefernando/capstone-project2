package com.goanna;

import com.goanna.controller.InputVariablesController;
import com.goanna.service.InputVariablesService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Arrays;
import java.util.List;

@WebMvcTest(controllers = InputVariablesController.class)
class InputVariablesControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    private InputVariablesService inputVariablesService;

    List<String> genderList = Arrays.asList("Male", "Female");

    @Test
    void statusAndSubmissionOfController() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/form"))
                .andExpect(status().isOk())
                .andExpect(view().name("form"))
                .andExpect(model().attribute("inputVariables", Matchers.notNullValue()))
                .andExpect(model().attribute("genderList", Matchers.is(genderList)));

        MvcResult mvcResult = resultActions.andReturn();
        ModelAndView mv = mvcResult.getModelAndView();
    }
}