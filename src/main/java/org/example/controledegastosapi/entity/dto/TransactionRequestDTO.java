package org.example.controledegastosapi.entity.dto;

import org.example.controledegastosapi.entity.Category;
import org.example.controledegastosapi.entity.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionRequestDTO(String description,
                                    double amount,
                                    TransactionType transactionType,
                                    LocalDate date,
                                    Category category) {
}
