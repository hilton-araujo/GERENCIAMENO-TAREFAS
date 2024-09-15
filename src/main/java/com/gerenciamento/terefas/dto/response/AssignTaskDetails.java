package com.gerenciamento.terefas.dto.response;

import com.gerenciamento.terefas.entity.Funcionario;
import com.gerenciamento.terefas.entity.Task;

public record AssignTaskDetails (
        String id,

        Task task,

        Funcionario funcionario
) {
}
