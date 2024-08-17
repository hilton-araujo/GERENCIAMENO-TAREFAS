package com.gerenciamento.terefas.service;

import com.gerenciamento.terefas.dto.DadosCadastroTarefa;
import com.gerenciamento.terefas.entity.Task;
import com.gerenciamento.terefas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
