package org.harsha.springbootinaction.mapper;

import org.harsha.springbootinaction.dto.UserRequestDto;
import org.harsha.springbootinaction.entity.AppUser;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
  public AppUser mapToUser(UserRequestDto userRequestDto) {
    return AppUser.builder()
        .fullName(userRequestDto.fullName())
        .username(userRequestDto.userName())
        .password(userRequestDto.password())
        .build();
  }
}
