package com.gerenciamento.terefas.dto;

import com.gerenciamento.terefas.enums.Status;

import java.time.LocalDate;

public record DadosCadastroTarefa(

        String description,

        LocalDate create_date,
        LocalDate finish_date,

        Status status
) {
}
