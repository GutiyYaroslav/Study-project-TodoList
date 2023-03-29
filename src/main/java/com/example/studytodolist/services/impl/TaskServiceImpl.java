package com.example.studytodolist.services.impl;

import com.example.studytodolist.dto.TaskDTO;
import com.example.studytodolist.models.Task;
import com.example.studytodolist.services.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    @Override
    public List<Task> getAllTaskFroUser(Long userId) {
        return null;
    }

    @Override
    public Task getTaskByIdFromUser(Long taskId, Long userId) {
        return null;
    }

    @Override
    public boolean deleteTaskByIdFromUser(Long taskId, Long userId) {
        return false;
    }

    @Override
    public Task addTask(TaskDTO taskDTO, Long userId) {
        return null;
    }

    @Override
    public Task editTask(TaskDTO taskDTO, Long userId) {
        return null;
    }
}
