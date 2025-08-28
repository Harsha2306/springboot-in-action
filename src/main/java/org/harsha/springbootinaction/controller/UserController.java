package org.harsha.springbootinaction.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.harsha.springbootinaction.dto.SuccessResponse;
import org.harsha.springbootinaction.dto.UserRequestDto;
import org.harsha.springbootinaction.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

  private final IUserService userService;

  @PostMapping
  public ResponseEntity<SuccessResponse<String>> registerUser(
      @RequestBody @Valid UserRequestDto userRequestDto) {
    userService.registerUser(userRequestDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("user created"));
  }
}
