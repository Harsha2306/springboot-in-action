package org.harsha.springbootinaction.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BookRequestDto(
    @NotBlank(message = "Reader is required") String reader,
    @NotBlank(message = "ISBN is required")
        @Size(min = 10, max = 13, message = "ISBN must be between 10 and 13 characters")
        String isbn,
    @NotBlank(message = "Title is required") String title,
    @NotBlank(message = "Author is required") String author,
    @Size(max = 1000, message = "Description must be at most 1000 characters")
        String description) {}
