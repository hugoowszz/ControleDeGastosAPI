package org.example.controledegastosapi.controller;

import org.example.controledegastosapi.entity.dto.CategoryRequestDTO;
import org.example.controledegastosapi.entity.dto.CategoryResponseDTO;
import org.example.controledegastosapi.service.CategoryService;
import org.example.controledegastosapi.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<CategoryResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping()
    public ResponseEntity<CategoryResponseDTO> create(@RequestBody CategoryRequestDTO category) {
        CategoryResponseDTO created = service.create(category);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(created.id()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> update(@PathVariable Long id, @RequestBody CategoryRequestDTO categoryRequestDTO) {
        return ResponseEntity.ok(service.update(id, categoryRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
