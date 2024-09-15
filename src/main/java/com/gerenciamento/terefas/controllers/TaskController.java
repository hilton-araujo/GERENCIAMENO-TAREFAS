package com.gerenciamento.terefas.controllers;

import com.gerenciamento.terefas.dto.DadosCadastroTarefa;
import com.gerenciamento.terefas.dto.ResponseApi;
import com.gerenciamento.terefas.service.TaskService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping(value = "/task")
    @Transactional
    public ResponseEntity<ResponseApi> cadastrar(@RequestBody @Valid DadosCadastroTarefa dadosCadastroTarefa){
        try {
            service.registar(dadosCadastroTarefa);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseApi("Tarefa Criada com sucesso", null));
        }catch (Exception e){

        }
        return null;
    }

    @GetMapping(value = "/task")
    public ResponseEntity<ResponseApi> listarTodasTarefas() throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseApi("Todas tarefas", service.listarTodasTarefas()));
    }

}
