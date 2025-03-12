package com.finlogic.task_app.business.repository.impl;

import com.finlogic.task_app.business.repository.TaskRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class TaskRepositoryImpl implements TaskRepository {
    @Override
    public List getData() {
        return List.of("Update spring version", "Meeting", "Change CSS");
    }
}
