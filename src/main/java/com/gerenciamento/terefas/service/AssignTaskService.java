package com.gerenciamento.terefas.service;

import com.gerenciamento.terefas.dto.AssignTaskDTO;
import com.gerenciamento.terefas.entity.AssignTask;
import com.gerenciamento.terefas.entity.Funcionario;
import com.gerenciamento.terefas.entity.Task;
import com.gerenciamento.terefas.repository.AssignTaskRepository;
import com.gerenciamento.terefas.repository.FuncionarioRepository;
import com.gerenciamento.terefas.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class AssignTaskService {

    private final AssignTaskRepository assignTaskRepository;

    private final FuncionarioRepository funcionarioRepository;

    private final TaskRepository taskRepository;

    public AssignTaskService(AssignTaskRepository assignTaskRepository, FuncionarioRepository funcionarioRepository, TaskRepository taskRepository) {
        this.assignTaskRepository = assignTaskRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.taskRepository = taskRepository;
    }

    public AssignTask create (AssignTask task){
        return assignTaskRepository.save(task);
    }

    public void atribuirTarefa(AssignTaskDTO dto) {
        try {
            AssignTask assignTask;

            Funcionario funcionario = funcionarioRepository.findById(dto.funcionarioId())
                    .orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));

            Task task = taskRepository.findById(dto.taskId())
                    .orElseThrow(() -> new RuntimeException("Tarefa não encontrado"));

            assignTask = new AssignTask();
            assignTask.setTask(task);
            assignTask.setFuncionario(funcionario);

            create(assignTask);

        }catch (Exception e){

        }

    }
}
