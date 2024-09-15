package com.gerenciamento.terefas.service;

import com.gerenciamento.terefas.dto.DadosCadastroTarefa;
import com.gerenciamento.terefas.dto.response.TaskDTO;
import com.gerenciamento.terefas.dto.response.TaskDTOS;
import com.gerenciamento.terefas.entity.Task;
import com.gerenciamento.terefas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public Task create (Task task){
        return repository.save(task);
    }

    public void registar(DadosCadastroTarefa dto){
        try {
            Task task;


            task = new Task();


            task.setDescription(dto.description());
            task.setCreate_data(dto.create_date());
            task.setFinish_data(dto.finish_date());
            task.setStatus(dto.status());

            create(task);

        } catch (Exception e) {

        }
    }

    public List<TaskDTOS> listarTodasTarefas() throws ChangeSetPersister.NotFoundException{
        List<Task> tasks = repository.findAll();

        List<TaskDTOS> dtos = new ArrayList<>();

        for (Task task : tasks) {
            TaskDTOS dto = new TaskDTOS(
                    task.getId(),
                    task.getDescription(),
                    task.getCreate_data(),
                    task.getFinish_data(),
                    task.getStatus()
            );
            dtos.add(dto);
        }
        return dtos;
    }
}
