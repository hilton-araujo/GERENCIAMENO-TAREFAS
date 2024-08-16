package com.gerenciamento.terefas.entity;

import com.gerenciamento.terefas.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "task")
@Setter
@Getter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "description", unique = true)
    private String description;

    @Column(name = "create_data", unique = true)
    private LocalDate create_data;

    @Column(name = "finish_data", unique = true)
    private LocalDate finish_data;

    @Column(name = "status", unique = true)
    @Enumerated(EnumType.STRING)
    private Status status;
}
