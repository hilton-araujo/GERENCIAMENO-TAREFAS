package com.gerenciamento.terefas.dto.response;

import com.gerenciamento.terefas.entity.AssignTask;
import com.gerenciamento.terefas.entity.Funcionario;
import com.gerenciamento.terefas.entity.Task;

import java.util.List;
import java.util.stream.Collectors;

public record EmployeeAssignTaskResDTO(
        String id,
        String nome,
        String email,
        List<TaskDTO> tasks
) {
    public EmployeeAssignTaskResDTO(Funcionario funcionario, List<AssignTask> assignTasks) {
        this(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getEmail(),
                assignTasks.stream()
                        .map(assignTask -> new TaskDTO(assignTask.getTask()))  // Mapeia cada tarefa para o DTO TaskDTO
                        .collect(Collectors.toList())
        );
    }
}
