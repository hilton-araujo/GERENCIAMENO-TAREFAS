package com.gerenciamento.terefas.controllers;

import com.gerenciamento.terefas.dto.AssignTaskDTO;
import com.gerenciamento.terefas.dto.ResponseApi;
import com.gerenciamento.terefas.service.AssignTaskService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/api")
public class AssignTaskController {

    private final AssignTaskService service;

    public AssignTaskController(AssignTaskService service) {
        this.service = service;
    }

    @PostMapping(value = "/assign-task")
    @Transactional
    public ResponseEntity<ResponseApi> atribuirTarefas(@RequestBody @Valid AssignTaskDTO dto){
        try {
            service.atribuirTarefa(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseApi("Tarefa atribuida com sucesso", null));
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(new ResponseApi(e.getReason(), null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseApi("Erro ao atribuir tarefa", null));
        }
    }

    @GetMapping(value = "/assign-task")
    public ResponseEntity<ResponseApi> listarTodasTarefasAtribuidas () throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseApi("Todas tarefas atribuidas", service.listarTodasTarefasAtribuidas()));
    }

    @GetMapping(value = "/employee/assign-task/{id}")
    public ResponseEntity<ResponseApi> listarTarefasAtribuidasFuncionario (@PathVariable String id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseApi("Todas tarefas atribuidas ao funcionario co id "+id, service.listarTarefasPorFuncionario(id)));
    }
}
