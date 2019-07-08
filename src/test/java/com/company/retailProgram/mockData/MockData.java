package com.company.retailProgram.mockData;

import com.company.retailProgram.model.MonthlyRewardDetails;
import com.company.retailProgram.model.RewardDetails;
import com.company.retailProgram.model.TransactionDetails;
import com.sun.tools.javac.util.List;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.time.LocalDate;

@UtilityClass
public class MockData {


    public TransactionDetails mockTransactionDetails() {
        TransactionDetails transactionDetails = new TransactionDetails();
        transactionDetails.setCustomerName("John");
        transactionDetails.setTransactionAmount(BigDecimal.valueOf(120));
        transactionDetails.setTransactionDate(LocalDate.now());
        return transactionDetails;
    }


    public RewardDetails mockRewardDetails() {
        MonthlyRewardDetails monthlyRewardDetails = new MonthlyRewardDetails();
        monthlyRewardDetails.setCustomerName("John");
        monthlyRewardDetails.setTransactionMonth("JULY");
        monthlyRewardDetails.setRewardPointsGained(90);

        RewardDetails rewardDetails = new RewardDetails();
        rewardDetails.setCustomerName(monthlyRewardDetails.getCustomerName());
        rewardDetails.setMonthlyRewardDetails(List.of(monthlyRewardDetails));
        rewardDetails.setTotalRewardPointsGained(90);
        return rewardDetails;
    }

}
