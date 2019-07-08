package com.company.retailProgram.controller;

import com.company.retailProgram.mockData.MockData;
import com.company.retailProgram.service.RetailProgramService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.tools.javac.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = RetailProgramController.class)
public class RetailProgramControllerTest {


    @MockBean
    private RetailProgramService retailProgramService;

    @Autowired
    private MockMvc mockMvc;


    private String requestParams;


    @Before
    public void setUp() throws JsonProcessingException {
        requestParams="[\n" +
                "\t{\n" +
                "\t\t\"customerName\": \"John\",\n" +
                "\t\t\"transactionAmount\": 120,\n" +
                "\t\t\"transactionDate\": \"2019-01-01\"\n" +
                "\t\t\t\n" +
                "\t}\n" +
                "]";
    }


    @Test
    public void getRewardPoints() throws Exception {

        given(retailProgramService.getRewardDetails(List.of(MockData.mockTransactionDetails())))
                .willReturn(List.of(MockData.mockRewardDetails()));

        mockMvc.perform(post("/rewardsApi/getRewardsPointDetails").content(requestParams).
                contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk());
    }








}