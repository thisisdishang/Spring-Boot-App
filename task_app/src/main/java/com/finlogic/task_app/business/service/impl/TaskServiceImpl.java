package com.finlogic.task_app.business.service.impl;

import com.finlogic.task_app.business.repository.TaskRepository;
import com.finlogic.task_app.business.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List getTasks() {
        return taskRepository.getData();
    }
}
