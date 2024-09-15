package com.gerenciamento.terefas.dto.response;

import com.gerenciamento.terefas.enums.Status;

import java.time.LocalDate;

public record TaskDTOS(
        String id,
        String description,
        LocalDate create_data,
        LocalDate finish_date,
        Status status
) {
}
