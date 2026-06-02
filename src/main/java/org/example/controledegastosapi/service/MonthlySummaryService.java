package org.example.controledegastosapi.service;

import org.example.controledegastosapi.entity.MonthlySummary;
import org.example.controledegastosapi.entity.Transaction;
import org.example.controledegastosapi.entity.TransactionType;
import org.example.controledegastosapi.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class MonthlySummaryService {

    private final TransactionRepository repository;

    public MonthlySummaryService(TransactionRepository repository) {
        this.repository = repository;
    }

    public MonthlySummary gastoMensal(int month, int year) {
        List<Transaction> transacoes = repository.findAllByMonthAndYear(month, year);
        MonthlySummary summary = new MonthlySummary();
        summary.setMonth(month);
        summary.setYear(year);
        double totalIncome = 0;// renda
        double totalExpense = 0;// despesa
        for(Transaction transacao : transacoes){
            if(transacao.getTransactionType() == TransactionType.INCOME){
                totalIncome += transacao.getAmount();
            } else if(transacao.getTransactionType() == TransactionType.EXPENSE){
                totalExpense += transacao.getAmount();
            }
        }
        summary.setTotalIncome(totalIncome);
        summary.setTotalExpense(totalExpense);
        summary.setBalance(totalIncome - totalExpense);
        return summary;
    }
    public MonthlySummary gastoCategoria(int categoria_id) {
        List<Transaction> transacoes = repository.findAllByCategoryId(categoria_id);
        MonthlySummary summary = new MonthlySummary();
        summary.setMonth(1);
        summary.setYear(1);
        double totalIncome = 0;// renda
        double totalExpense = 0;// despesa
        for(Transaction transacao : transacoes){
            if(transacao.getTransactionType() == TransactionType.INCOME){
                totalIncome += transacao.getAmount();
            } else if(transacao.getTransactionType() == TransactionType.EXPENSE){
                totalExpense += transacao.getAmount();
            }
        }
        summary.setTotalIncome(totalIncome);
        summary.setTotalExpense(totalExpense);
        summary.setBalance(totalIncome - totalExpense);
        return summary;
    }

}
