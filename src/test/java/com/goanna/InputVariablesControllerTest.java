package com.goanna;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InputVariablesControllerTest {

    protected MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    protected void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /*@Test
    void inputSubmit() {
        String urlToTest = "/form";
        MvcResult mvcResult = mvc.perform(MockMvc)

                //this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
        //.andExpect(content().string(containsString("Hello, World")));
    }*/
}