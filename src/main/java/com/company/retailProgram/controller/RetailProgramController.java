package com.company.retailProgram.controller;

import com.company.retailProgram.model.RewardDetails;
import com.company.retailProgram.model.TransactionDetails;
import com.company.retailProgram.service.RetailProgramService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("rewardsApi")
public class RetailProgramController {

    @Autowired
    private RetailProgramService retailProgramService;

    @PostMapping("getRewardsPointDetails")
    public List<RewardDetails> getRewardPoints(@RequestBody List<TransactionDetails> transactionDetails){
        log.info("in getRewardPoints");
       return retailProgramService.getRewardDetails(transactionDetails);
    }



}
