package org.example.repositories;

import org.example.entity.Task;

import java.util.List;

/**
 * @author kurstan
 * @created at 27.01.2023 11:29
 */
public interface TaskRepository {
    void saveTask(Long lessonId, Task task);

    void updateTask(Long oldTaskId, Task newTask);

    List<Task> getAllTaskByLessonId(Long lessonId);

    void deleteTaskById(Long id);
}
