package com.gerenciamento.terefas.dto;

import com.gerenciamento.terefas.enums.Roles;

public record AuthResisterDTO(

        String login,

        String password,

        Roles roles
) {
}
