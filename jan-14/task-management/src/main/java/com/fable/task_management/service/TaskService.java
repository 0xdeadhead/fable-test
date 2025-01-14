package com.fable.task_management.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.fable.task_management.dto.TaskDTO;
import com.fable.task_management.dto.TaskStatus;
import com.fable.task_management.entity.Task;

public interface TaskService {

    public Page<Task> findAll(TaskStatus taskStatus, String description, Integer priority, PageRequest pageRequest);

    public Task findTaskById(Long id);

    public TaskDTO updateTask(TaskDTO taskDTO);

    public void deleteTask(Long taskId);

    public TaskDTO addTask(TaskDTO taskDTO);
}
