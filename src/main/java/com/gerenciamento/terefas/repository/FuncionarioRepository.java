package com.gerenciamento.terefas.repository;

import com.gerenciamento.terefas.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    // Aqui você pode adicionar métodos customizados, se necessário
}
