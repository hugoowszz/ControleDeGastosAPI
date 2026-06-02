package org.example.controledegastosapi.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.controledegastosapi.entity.Transaction;
import org.example.controledegastosapi.entity.dto.TransactionRequestDTO;
import org.example.controledegastosapi.entity.dto.TransactionResponseDTO;
import org.example.controledegastosapi.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<TransactionResponseDTO> findAll() {
        return repository.findAll().stream().map(TransactionResponseDTO::from).toList();
    }

    public TransactionResponseDTO findById(Long id) {
        Transaction transaction = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Transaction not found"));
        return TransactionResponseDTO.from(transaction);
    }

    public TransactionResponseDTO create(TransactionRequestDTO dto) {
        Transaction transaction = new Transaction();
        transaction.setDescription(dto.description());
        transaction.setAmount(dto.amount());
        transaction.setTransactionType(dto.transactionType());
        transaction.setDate(dto.date());
        transaction.setCategory(dto.category());
        transaction.setCreatedAt(LocalDateTime.now());
        repository.save(transaction);
        return TransactionResponseDTO.from(transaction);
    }

    public TransactionResponseDTO update(Long id, TransactionRequestDTO dto) {
        Transaction transaction = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Transaction not found"));
        transaction.setDescription(dto.description());
        transaction.setAmount(dto.amount());
        transaction.setTransactionType(dto.transactionType());
        transaction.setDate(dto.date());
        transaction.setCategory(dto.category());
        return TransactionResponseDTO.from(repository.save(transaction));
    }

    public void delete(Long id) {
        Transaction transaction = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Transaction not found"));
        repository.deleteById(id);
    }

}
