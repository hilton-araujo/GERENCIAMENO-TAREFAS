package com.gerenciamento.terefas.service;

import com.gerenciamento.terefas.dto.AssignTaskDTO;
import com.gerenciamento.terefas.dto.response.AssignTaskDetails;
import com.gerenciamento.terefas.dto.response.AssignTaskResDTO;
import com.gerenciamento.terefas.dto.response.EmployeeAssignTaskResDTO;
import com.gerenciamento.terefas.entity.AssignTask;
import com.gerenciamento.terefas.entity.Funcionario;
import com.gerenciamento.terefas.entity.Task;
import com.gerenciamento.terefas.repository.AssignTaskRepository;
import com.gerenciamento.terefas.repository.FuncionarioRepository;
import com.gerenciamento.terefas.repository.TaskRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao atribuir tarefa", e);
        }

    }

    public List<AssignTaskResDTO> listarTodasTarefasAtribuidas() throws ChangeSetPersister.NotFoundException {
        List<AssignTask> tasks = assignTaskRepository.findAll();

        List<AssignTaskResDTO> dtos = new ArrayList<>();

        for (AssignTask assignTask : tasks) {
            AssignTaskResDTO assignTaskResDTO = new AssignTaskResDTO(
              assignTask.getId(),
              assignTask.getTask().getDescription(),
              assignTask.getFuncionario().getNome()
            );
            dtos.add(assignTaskResDTO);
        }
        return dtos;
    }

    public EmployeeAssignTaskResDTO listarTarefasPorFuncionario(String funcionarioId) {
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionario não encontrado"));

        List<AssignTask> tasks = assignTaskRepository.findByFuncionario(funcionario);

        return new EmployeeAssignTaskResDTO(funcionario, tasks);
    }

    public AssignTaskDetails listarTarefaAtribuida(String assignTaskId) {
        AssignTask assignTask = assignTaskRepository.findById(assignTaskId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa atribuída não encontrada"));

        AssignTaskDetails assignTaskDetails = new AssignTaskDetails(
                assignTask.getId(),
                assignTask.getTask(),
                assignTask.getFuncionario()
        );
        return assignTaskDetails;
    }


}
