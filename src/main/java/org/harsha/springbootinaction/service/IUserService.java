package org.harsha.springbootinaction.service;

import org.harsha.springbootinaction.dto.UserRequestDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
  void registerUser(UserRequestDto userRequestDto);
}
