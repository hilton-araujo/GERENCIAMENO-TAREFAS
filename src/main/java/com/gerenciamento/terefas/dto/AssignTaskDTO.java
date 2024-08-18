package com.gerenciamento.terefas.dto;

import jakarta.validation.constraints.NotNull;

public record AssignTaskDTO(

        @NotNull(message = "A tarefa não pode ser nulo")
        String taskId,

        @NotNull(message = "O funcionario não pode ser nulo")
        String funcionarioId
) {
}
