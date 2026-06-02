package org.example.controledegastosapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class MonthlySummary {

    private int month;
    private int year;
    private double totalIncome;// renda
    private double totalExpense;// despesa
    private double balance;

}
