package com.goanna;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = InputVariablesController.class)
class InputVariablesControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    //@Autowired
    //WebApplicationContext webApplicationContext;

    //protected void setUp() {
    //    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    //}

    List<String> genderList = Arrays.asList("Male", "Female");

    @Test
    void inputSubmit() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/form"))
                .andExpect(status().isOk())
                .andExpect(view().name("form"))
                .andExpect(model().attribute("inputVariables", Matchers.is(new InputVariables())))
                .andExpect(model().attribute("genderList", Matchers.is(genderList)));

        MvcResult mvcResult = resultActions.andReturn();
        ModelAndView mv = mvcResult.getModelAndView();


    }
}