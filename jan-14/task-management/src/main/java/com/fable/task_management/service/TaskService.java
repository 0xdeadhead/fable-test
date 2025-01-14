package com.fable.task_management.service;

import java.util.List;

import com.fable.task_management.dto.TaskDTO;
import com.fable.task_management.entity.Task;

public interface TaskService {

    public List<Task> findAll();

    public Task findTaskById(Long id);

    public TaskDTO updateTask(TaskDTO taskDTO);

    public void deleteTask(Long taskId);

    public TaskDTO addTask(TaskDTO taskDTO);
}
