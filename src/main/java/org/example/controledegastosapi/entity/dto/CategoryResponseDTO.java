package org.example.controledegastosapi.entity.dto;

import org.example.controledegastosapi.entity.Category;

import java.time.LocalDateTime;

public record CategoryResponseDTO(Long id, String name, String color, String icon, LocalDateTime createdAt) {

    public static CategoryResponseDTO from(Category category) {
        return new CategoryResponseDTO(
                category.getId(),
                category.getName(),
                category.getColor(),
                category.getIcon(),
                category.getCreatedAt());
    }
}
