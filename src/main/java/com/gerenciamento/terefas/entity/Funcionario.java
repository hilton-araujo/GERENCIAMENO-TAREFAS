package com.gerenciamento.terefas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "funcionario")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nome;

    private String email;

    private String password;
}
