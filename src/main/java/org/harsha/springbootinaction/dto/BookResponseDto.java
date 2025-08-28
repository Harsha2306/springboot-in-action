package org.harsha.springbootinaction.dto;

import lombok.Builder;

@Builder
public record BookResponseDto(
    Long id, String reader, String isbn, String title, String author, String description) {}
