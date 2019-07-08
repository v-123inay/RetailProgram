package com.company.retailProgram.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = {"rewordPointsGained"})
public class MonthlyRewardDetails {

    @JsonIgnore
    private String customerName;
    private String transactionMonth;
    private Integer rewardPointsGained;




}
