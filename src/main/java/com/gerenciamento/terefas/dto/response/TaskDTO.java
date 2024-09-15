package com.gerenciamento.terefas.dto.response;

import com.gerenciamento.terefas.entity.Task;

import java.time.format.DateTimeFormatter;

public record TaskDTO(
        String id,
        String description,
        String createDate,
        String finishDate,
        String status
) {
    public TaskDTO(Task task) {
        this(
                task.getId(),
                task.getDescription(),
                task.getCreate_data().format(DateTimeFormatter.ISO_DATE),
                task.getFinish_data().format(DateTimeFormatter.ISO_DATE),
                String.valueOf(task.getStatus())
        );
    }
}

