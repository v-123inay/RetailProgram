package com.company.retailProgram.service;

import com.company.retailProgram.model.MonthlyRewardDetails;
import com.company.retailProgram.model.RewardDetails;
import com.company.retailProgram.model.TransactionDetails;
import com.company.retailProgram.util.RewardPointCalculator;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Log4j2
@Service
public class RetailProgramService {


    public List<RewardDetails> getRewardDetails(List<TransactionDetails> transactionDetails) {
        log.info("getRewardDetails: STARTS");
        List<RewardDetails> rewardDetailsList = new ArrayList<>();
        List<MonthlyRewardDetails> monthlyRewardDetails = calculateMonthlyRewardDetails(transactionDetails);

        final Map<String, List<MonthlyRewardDetails>> customerWiseMontlyRewardsPointsMap =
                monthlyRewardDetails.stream().collect(Collectors.groupingBy(MonthlyRewardDetails::getCustomerName, Collectors.toList()));


        for (String customer : customerWiseMontlyRewardsPointsMap.keySet()) {

            List<MonthlyRewardDetails> monthlyRewards = customerWiseMontlyRewardsPointsMap.get(customer);
            int totalPointsGained = monthlyRewards.stream().mapToInt(MonthlyRewardDetails::getRewardPointsGained).sum();
            RewardDetails rewardDetails = new RewardDetails();
            rewardDetails.setCustomerName(customer);
            rewardDetails.setMonthlyRewardDetails(monthlyRewards);
            rewardDetails.setTotalRewardPointsGained(totalPointsGained);
            rewardDetailsList.add(rewardDetails);
        }

        log.info("getRewardDetails: ENDS");
        return rewardDetailsList;
    }


    private List<MonthlyRewardDetails> calculateMonthlyRewardDetails(List<TransactionDetails> transactionDetails) {
        log.info("calculateMonthlyRewardDetails: STARTS");
        List<MonthlyRewardDetails> monthlyRewardDetailsList = new ArrayList<>();
        Map<MonthlyRewardDetails, Integer> monthlyRewardsMap = new HashMap<>();

        for (TransactionDetails transaction : transactionDetails) {

            String month = transaction.getTransactionDate().getMonth().name();

            MonthlyRewardDetails monthlyRewardDetails = new MonthlyRewardDetails();
            monthlyRewardDetails.setCustomerName(transaction.getCustomerName());
            monthlyRewardDetails.setTransactionMonth(month);


            int rewardsPoints = RewardPointCalculator.calculateRewordPoints(transaction.getTransactionAmount());
            if (monthlyRewardsMap.get(monthlyRewardDetails) != null) {
                int points = monthlyRewardsMap.get(monthlyRewardDetails);

                monthlyRewardsMap.put(monthlyRewardDetails, points + rewardsPoints);

            }
            monthlyRewardsMap.put(monthlyRewardDetails, rewardsPoints);

        }

        for (MonthlyRewardDetails monthlyRewardDetails : monthlyRewardsMap.keySet()) {
            monthlyRewardDetails.setRewardPointsGained(monthlyRewardsMap.get(monthlyRewardDetails));
            monthlyRewardDetailsList.add(monthlyRewardDetails);
        }
        log.info("calculateMonthlyRewardDetails: ENDS");

        return monthlyRewardDetailsList;
    }

}
