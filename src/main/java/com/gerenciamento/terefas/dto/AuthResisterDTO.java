package com.gerenciamento.terefas.dto;

import com.gerenciamento.terefas.enums.Roles;

public record AuthResisterDTO(

        String username,

        String password,

        Roles roles
) {
}
