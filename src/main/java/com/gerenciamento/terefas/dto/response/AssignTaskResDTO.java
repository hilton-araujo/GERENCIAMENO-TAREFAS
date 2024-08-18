package com.gerenciamento.terefas.dto.response;

import jakarta.validation.constraints.NotBlank;

public record AssignTaskResDTO (

        String id,

        String task,

        String funcionario
){
}
