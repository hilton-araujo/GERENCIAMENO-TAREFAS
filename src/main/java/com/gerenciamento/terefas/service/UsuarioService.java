package com.gerenciamento.terefas.service;

import com.gerenciamento.terefas.entity.Auth;
import com.gerenciamento.terefas.exceptions.ContentAlreadyExistsException;
import com.gerenciamento.terefas.repository.AuthRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final AuthRepository authRepository;

    private final PasswordEncoder passwordEncoder;

    public UsuarioService(AuthRepository authRepository, PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Auth criarUsuario(Auth auth) throws ContentAlreadyExistsException {
        if (usuarioExistePorUsername(auth.getUsername())) {
            throw new ContentAlreadyExistsException("Já existe um usuário com esse username!");
        }

        auth.setCreatedBy(auth.getUsername());
        auth.setUpdatedBy(auth.getUsername());
        auth.setPassword(passwordEncoder.encode(auth.getPassword()));
        return authRepository.save(auth);
    }

    public Boolean usuarioExistePorUsername(String username) {
        return authRepository.existsByUsername(username);
    }
}
