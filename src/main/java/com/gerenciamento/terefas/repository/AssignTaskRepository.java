package com.gerenciamento.terefas.repository;

import com.gerenciamento.terefas.entity.AssignTask;
import com.gerenciamento.terefas.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignTaskRepository extends JpaRepository<AssignTask, String> {
    List<AssignTask> findByFuncionario(Funcionario funcionario);
}

