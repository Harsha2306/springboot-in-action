package org.harsha.springbootinaction.dto;

import jakarta.validation.constraints.NotBlank;

public record UserRequestDto(
    @NotBlank String userName, @NotBlank String password, @NotBlank String fullName) {}
