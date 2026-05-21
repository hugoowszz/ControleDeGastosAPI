package org.example.controledegastosapi.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.controledegastosapi.entity.Category;
import org.example.controledegastosapi.entity.dto.CategoryRequestDTO;
import org.example.controledegastosapi.entity.dto.CategoryResponseDTO;
import org.example.controledegastosapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<CategoryResponseDTO> findAll() {
        return repository.findAll().stream().map(CategoryResponseDTO::from).toList();
    }

    public CategoryResponseDTO create(CategoryRequestDTO dto) {
        Category category = new Category();
        category.setName(dto.name());
        category.setColor(dto.color());
        category.setIcon(dto.icon());
        category.setCreatedAt(LocalDateTime.now());
        return CategoryResponseDTO.from(repository.save(category));
    }

    public CategoryResponseDTO update(Long id, CategoryRequestDTO dto) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        category.setName(dto.name());
        category.setColor(dto.color());
        category.setIcon(dto.icon());
        return CategoryResponseDTO.from(repository.save(category));
    }

    public void delete(Long id) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        repository.delete(category);
    }
}
