package com.gerenciamento.terefas.dto;

import com.gerenciamento.terefas.entity.Funcionario;
import com.gerenciamento.terefas.entity.Task;
import jakarta.validation.constraints.NotBlank;

public record AssignTaskDTO(

        @NotBlank(message = "A tarefa não pode ser nulo")
        String taskId,

        @NotBlank(message = "O funcionario não pode ser nulo")
        String funcionarioId
) {
}
