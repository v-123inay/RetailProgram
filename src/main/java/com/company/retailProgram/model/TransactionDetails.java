package com.company.retailProgram.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TransactionDetails {


    private String customerName;
    private BigDecimal transactionAmount;
    private LocalDate transactionDate;

}
