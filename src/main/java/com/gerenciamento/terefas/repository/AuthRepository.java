package com.gerenciamento.terefas.repository;

import com.gerenciamento.terefas.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {
    UserDetails findByUsername(String username);

    Boolean existsByUsername(String username);
}
