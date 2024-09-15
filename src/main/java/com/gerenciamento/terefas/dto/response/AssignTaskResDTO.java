package com.gerenciamento.terefas.dto.response;

import com.gerenciamento.terefas.entity.Task;

public record AssignTaskResDTO (

        String id,

        String task,

        String funcionario
){
}

