package com.fable.task_management.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fable.task_management.dto.TaskDTO;
import com.fable.task_management.dto.TaskStatus;
import com.fable.task_management.entity.Task;
import com.fable.task_management.exception.BusinessException;
import com.fable.task_management.repository.TaskRepository;

import jakarta.transaction.Transactional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findTaskById(Long id) {
        return this.taskRepository.findById(id)
                .orElseThrow(
                        () -> BusinessException.builder().message("Unable to find task with id : " + id).status(404)
                                .build());
    }

    @Override
    @Transactional
    public TaskDTO updateTask(TaskDTO taskDTO) {
        Task taskEntity = taskRepository.findById(taskDTO.getId()).orElseThrow(
                () -> BusinessException.builder().message("Unable to find task with id : " + taskDTO.getId())
                        .status(404)
                        .build());
        modelMapper.map(taskDTO, taskEntity);
        return modelMapper.map(taskRepository.save(taskEntity), TaskDTO.class);
    }

    @Override
    @Transactional
    public void deleteTask(Long taskId) {
        Task taskEntity = taskRepository.findById(taskId).orElseThrow(
                () -> BusinessException.builder().message("Unable to find task with id : " + taskId)
                        .status(404)
                        .build());
        taskRepository.delete(taskEntity);
    }

    @Override
    @Transactional
    public TaskDTO addTask(TaskDTO taskDTO) {
        Task taskEntity = modelMapper.map(taskDTO, Task.class);
        taskEntity.setStatus(TaskStatus.CREATED);
        return modelMapper.map(taskRepository.save(taskEntity), TaskDTO.class);
    }

}
