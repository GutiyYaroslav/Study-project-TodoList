package com.example.studytodolist.services;

import com.example.studytodolist.dto.TaskDTO;
import com.example.studytodolist.models.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTaskFroUser(Long userId);
    Task getTaskByIdFromUser(Long taskId, Long userId);
    boolean deleteTaskByIdFromUser(Long taskId, Long userId);
    Task addTask(TaskDTO taskDTO, Long userId);
    Task editTask(TaskDTO taskDTO, Long userId);

}
