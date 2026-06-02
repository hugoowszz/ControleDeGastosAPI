package org.example.controledegastosapi.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.controledegastosapi.entity.Transaction;
import org.example.controledegastosapi.entity.dto.TransactionRequestDTO;
import org.example.controledegastosapi.entity.dto.TransactionResponseDTO;
import org.example.controledegastosapi.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<TransactionResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping()
    public ResponseEntity<TransactionResponseDTO> create(@RequestBody TransactionRequestDTO transaction) {
        TransactionResponseDTO created = service.create(transaction);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(created.Id()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionResponseDTO> update(@PathVariable Long id, @RequestBody TransactionRequestDTO transaction) {
        return ResponseEntity.ok(service.update(id, transaction));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TransactionResponseDTO> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
