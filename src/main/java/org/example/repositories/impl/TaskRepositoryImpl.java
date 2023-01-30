package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.config.HibernateConfig;
import org.example.entity.Lesson;
import org.example.entity.Task;
import org.example.repositories.TaskRepository;

import java.util.List;

/**
 * @author kurstan
 * @created at 27.01.2023 11:28
 */
public class TaskRepositoryImpl implements TaskRepository, AutoCloseable {
    private EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManager();
    @Override
    public void saveTask(Long lessonId, Task task) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, lessonId);
        lesson.getTasks().add(task);
        entityManager.persist(task);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateTask(Long oldTaskId, Task newTask) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Task task = entityManager.find(Task.class, oldTaskId);
        task.setName(newTask.getName());
        task.setTask(newTask.getTask());
        task.setDeadLine(newTask.getDeadLine());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long lessonId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, lessonId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return lesson.getTasks();
    }

    @Override
    public void deleteTaskById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Task task = entityManager.find(Task.class, id);
        List<Lesson> lessons = entityManager.createQuery("from Lesson ", Lesson.class).getResultList();
        for (int i = 0; i < lessons.size(); i++) {
            lessons.get(i).getTasks().remove(task);
        }
        entityManager.remove(task);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
