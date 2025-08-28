package org.harsha.springbootinaction.dto;

import java.util.Map;

public record ErrorResponseDto(String message, Map<String, String> errors) {}
