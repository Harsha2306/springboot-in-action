package org.harsha.springbootinaction.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.harsha.springbootinaction.dto.UserRequestDto;
import org.harsha.springbootinaction.entity.AppUser;
import org.harsha.springbootinaction.mapper.UserMapper;
import org.harsha.springbootinaction.repository.UserRepository;
import org.harsha.springbootinaction.service.IUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
  private final UserRepository userRepository;

  private final UserMapper userMapper;

  private final PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    return userRepository
        .findByUsername(userName)
        .orElseThrow(
            () -> new UsernameNotFoundException("user wit username " + userName + " not found"));
  }

  @Override
  public void registerUser(UserRequestDto userRequestDto) {
    log.info("user:{} saved", userRequestDto.userName());
    AppUser user = userMapper.mapToUser(userRequestDto);
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepository.save(user);
  }
}
