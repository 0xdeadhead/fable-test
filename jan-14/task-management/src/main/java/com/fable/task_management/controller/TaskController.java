package com.fable.task_management.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fable.task_management.dto.TaskDTO;
import com.fable.task_management.service.TaskService;


@RestController
@RequestMapping("/api/task/")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/")
    private List<TaskDTO> get() {
        return taskService.findAll().stream().map(e -> modelMapper.map(e, TaskDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/{taskId}")
    private TaskDTO getById(@PathVariable("taskId") String taskId) {
        return modelMapper.map(taskService.findTaskById(Long.parseLong(taskId)), TaskDTO.class);
    }

    @PostMapping("/")
    private TaskDTO add(@RequestBody TaskDTO taskDTO) {
        return taskService.addTask(taskDTO);
    }

    @PutMapping("/{taskId}")
    private TaskDTO put(@RequestBody TaskDTO taskDTO, @PathVariable("taskId") String taskId) {
        taskDTO.setId(Long.parseLong(taskId));
        return taskService.updateTask(taskDTO);
    }

    @DeleteMapping("/{taskId}")
    private ResponseEntity<Map<String,String>> delete(@PathVariable("taskId") String taskId) {
        taskService.deleteTask(Long.parseLong(taskId));
        return ResponseEntity.ok().body(Map.of("message","deleted task"));
    }

}
