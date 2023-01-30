package org.example.services;

import org.example.entity.Task;

import java.util.List;

/**
 * @author kurstan
 * @created at 27.01.2023 11:31
 */
public interface TaskService {
    String saveTask(Long lessonId, Task task);

    String updateTask(Long oldTaskId, Task newTask);

    List<Task> getAllTaskByLessonId(Long lessonId);

    String deleteTaskById(Long id);
}
