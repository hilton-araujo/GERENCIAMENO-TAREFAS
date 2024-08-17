package com.gerenciamento.terefas.dto;

import com.gerenciamento.terefas.enums.Status;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroTarefa(

        String description,

        @NotNull
        LocalDate create_date,

        LocalDate finish_date,

        Status status
) {
}
