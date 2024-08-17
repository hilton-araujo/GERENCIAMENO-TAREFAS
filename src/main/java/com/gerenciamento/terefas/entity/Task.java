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
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "description", unique = true, nullable = false)
    private String description;

    @Column(name = "create_data", unique = true, nullable = false)
    private LocalDate create_data;

    @Column(name = "finish_data", unique = true, nullable = false)
    private LocalDate finish_data;

    @Column(name = "status", unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
}
