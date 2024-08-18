package com.gerenciamento.terefas.repository;

import com.gerenciamento.terefas.entity.AssignTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignTaskRepository extends JpaRepository<AssignTask, String> {
}
