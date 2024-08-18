package com.gerenciamento.terefas.service;

import com.gerenciamento.terefas.dto.FuncionarioCadastroDTO;
import com.gerenciamento.terefas.entity.Auth;
import com.gerenciamento.terefas.entity.Funcionario;
import com.gerenciamento.terefas.enums.Roles;
import com.gerenciamento.terefas.exceptions.ContentAlreadyExistsException;
import com.gerenciamento.terefas.repository.AuthRepository;
import com.gerenciamento.terefas.repository.FuncionarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class FuncionarioService {

    private final AuthRepository authRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final PasswordEncoder passwordEncoder;

    public FuncionarioService(AuthRepository authRepository, FuncionarioRepository funcionarioRepository, PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Funcionario criarFuncionario(Funcionario funcionario) throws ContentAlreadyExistsException {
        if (authRepository.existsByUsername(funcionario.getEmail())) {
            throw new ContentAlreadyExistsException("Já existe um usuário com esse email!");
        }

        String encryptedPassword = passwordEncoder.encode(funcionario.getPassword());

        Auth auth = new Auth(
                funcionario.getEmail(),
                encryptedPassword,
                Roles.USER
        );

        authRepository.save(auth);

        Funcionario novoFuncionario = funcionarioRepository.save(funcionario);

        return novoFuncionario;
    }
}

