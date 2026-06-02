package org.example.controledegastosapi.entity.dto;

import org.example.controledegastosapi.entity.Category;
import org.example.controledegastosapi.entity.Transaction;
import org.example.controledegastosapi.entity.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record TransactionResponseDTO(Long Id,
                                     String description,
                                     double amount,
                                     TransactionType transactionType,
                                     LocalDate date,
                                     Category category,
                                     LocalDateTime createdAt) {

    public static TransactionResponseDTO from(Transaction transaction) {
        return new TransactionResponseDTO(
                transaction.getId(),
                transaction.getDescription(),
                transaction.getAmount(),
                transaction.getTransactionType(),
                transaction.getDate(),
                transaction.getCategory(),
                transaction.getCreatedAt());
    }
}
