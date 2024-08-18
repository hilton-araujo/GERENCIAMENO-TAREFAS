package com.gerenciamento.terefas.controllers;

import com.gerenciamento.terefas.entity.Funcionario;
import com.gerenciamento.terefas.exceptions.ContentAlreadyExistsException;
import com.gerenciamento.terefas.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsauarioController {

    private final FuncionarioService funcionarioService;

    public UsauarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    // Endpoint para criar um novo funcionário
    @PostMapping("/funcionario")
    public ResponseEntity<Funcionario> criarFuncionario(@RequestBody Funcionario funcionario) throws ContentAlreadyExistsException {
        Funcionario novoFuncionario = funcionarioService.criarFuncionario(funcionario);
        return new ResponseEntity<>(novoFuncionario, HttpStatus.CREATED);
    }

}
