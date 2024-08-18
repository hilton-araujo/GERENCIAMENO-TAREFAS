package com.gerenciamento.terefas.dto.response;

import com.gerenciamento.terefas.entity.Funcionario;
import com.gerenciamento.terefas.entity.Task;

public record EmployeeAssignTaskResDTO(

        String id,

        Task task,

        Funcionario funcionario
) {
}
