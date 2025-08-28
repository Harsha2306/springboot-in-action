package org.harsha.springbootinaction.repository;

import java.util.Optional;
import org.harsha.springbootinaction.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, String> {
  Optional<AppUser> findByUsername(String userName);
}
