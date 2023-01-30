package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.config.HibernateConfig;
import org.example.entity.Course;
import org.example.repositories.CourseRepository;

import java.util.List;

/**
 * @author kurstan
 * @created at 27.01.2023 11:26
 */
public class CourseRepositoryImpl implements CourseRepository, AutoCloseable {
    private EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManager();

    @Override
    public void saveCourse(Course course) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.merge(course);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Course getCourseById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
    }

    @Override
    public List<Course> getAllCourse() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Course> courses = entityManager.createQuery("from Course order by createAt", Course.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return courses;
    }

    @Override
    public void updateCourse(Long oldCourseId, Course newCourse) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, oldCourseId);
        course.setCourseName(newCourse.getCourseName());
        course.setDescription(newCourse.getDescription());
        course.setDuration(newCourse.getDuration());
        course.setLessons(newCourse.getLessons());
        course.setInstructors(newCourse.getInstructors());
        course.setCreateAt(newCourse.getCreateAt());
        course.setImageLink(newCourse.getImageLink());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteCourseById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Course.class, id));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Course getCourseByName(String courseName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager
                .createQuery("from Course where courseName = :name", Course.class)
                .setParameter("name", courseName)
                        .getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
