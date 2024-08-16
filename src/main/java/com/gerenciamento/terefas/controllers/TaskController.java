package com.gerenciamento.terefas.controllers;

import com.gerenciamento.terefas.dto.DadosCadastroTarefa;
import com.gerenciamento.terefas.service.TaskService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid DadosCadastroTarefa dadosCadastroTarefa){
        try {
            service.registar(dadosCadastroTarefa);
        }catch (Exception e){

        }
        return null;
    }
}
