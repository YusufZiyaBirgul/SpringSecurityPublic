package yte.spring_security.spring_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.spring_security.spring_security.entity.Users;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
}
