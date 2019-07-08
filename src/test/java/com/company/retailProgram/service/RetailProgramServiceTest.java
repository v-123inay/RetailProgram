package com.company.retailProgram.service;

import com.company.retailProgram.mockData.MockData;
import com.company.retailProgram.model.RewardDetails;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RetailProgramServiceTest {

    @Test
    public void getRewardDetails() {

        RetailProgramService retailProgramService= new RetailProgramService();
        List<RewardDetails> rewardDetails = retailProgramService.getRewardDetails(List.of(MockData.mockTransactionDetails()));
        assertNotNull(rewardDetails);

    }
}