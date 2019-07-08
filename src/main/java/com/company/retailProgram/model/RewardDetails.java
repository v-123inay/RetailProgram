package com.company.retailProgram.model;

import lombok.Data;

import java.util.List;

@Data
public class RewardDetails {

    private String customerName;
    private Integer totalRewardPointsGained;
    private List<MonthlyRewardDetails> monthlyRewardDetails;




}
