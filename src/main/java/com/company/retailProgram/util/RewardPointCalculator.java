package com.company.retailProgram.util;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

@UtilityClass
public class RewardPointCalculator {


    /**
     * Method to calculate the rewordPoints for a transaction
     * Here we are calculating the rewards point only if the transaction
     * is greater or equals to 100$
     * @param transactionAmount
     * @return
     */
    public int calculateRewordPoints(BigDecimal transactionAmount){
        int rewardsPoints=0;
        if(transactionAmount!=null && transactionAmount.intValue()>=100) {
            int transAmount = transactionAmount.intValue();
              rewardsPoints+=(transAmount-100)*2+1*50;
        }
       return rewardsPoints;
    }






}
