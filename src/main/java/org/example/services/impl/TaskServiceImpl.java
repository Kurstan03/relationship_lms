package org.example.services.impl;

import org.example.entity.Task;
import org.example.repositories.TaskRepository;
import org.example.repositories.impl.TaskRepositoryImpl;
import org.example.services.TaskService;

import java.util.List;

/**
 * @author kurstan
 * @created at 27.01.2023 11:33
 */
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository = new TaskRepositoryImpl();
    @Override
    public String  saveTask(Long lessonId, Task task) {
        taskRepository.saveTask(lessonId, task);
        return "Task " + task.getName() + " is saved!";
    }

    @Override
    public String updateTask(Long oldTaskId, Task newTask) {
        taskRepository.updateTask(oldTaskId, newTask);
        return "Task by name " + newTask.getName() + " is updated for id - " + oldTaskId;
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long lessonId) {
        return taskRepository.getAllTaskByLessonId(lessonId);
    }

    @Override
    public String deleteTaskById(Long id) {
        taskRepository.deleteTaskById(id);
        return "Task by id - " + id + " is deleted!";
    }
}
