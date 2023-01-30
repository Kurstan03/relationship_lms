package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.config.HibernateConfig;
import org.example.entity.Course;
import org.example.entity.Lesson;
import org.example.repositories.LessonRepository;

import java.util.List;

/**
 * @author kurstan
 * @created at 27.01.2023 11:27
 */
public class LessonRepositoryImpl implements LessonRepository, AutoCloseable {
    EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManager();
    @Override
    public void saveLesson(Long courseId, Lesson lesson) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, courseId);
        entityManager.persist(lesson);
        course.getLessons().add(lesson);
        lesson.setCourse(course);
        entityManager.merge(course);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateLesson(Long oldLessonId, Lesson lesson) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Lesson lesson1 = entityManager.find(Lesson.class, oldLessonId);
        lesson1.setName(lesson.getName());
        lesson1.setTasks(lesson.getTasks());
        lesson1.setVideoLink(lesson.getVideoLink());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Lesson getLessonById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return lesson;
    }

    @Override
    public List<Lesson> getLessonsByCourseId(Long courseId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, courseId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course.getLessons();
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
