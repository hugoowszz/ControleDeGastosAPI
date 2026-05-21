package org.example.controledegastosapi.entity.dto;

import org.hibernate.annotations.processing.Pattern;

public record CategoryRequestDTO(String name,
                                 String color,
                                 String icon) {
}
