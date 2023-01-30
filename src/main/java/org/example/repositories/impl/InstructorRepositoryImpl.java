package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.config.HibernateConfig;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.repositories.InstructorRepository;

import java.util.List;

/**
 * @author kurstan
 * @created at 27.01.2023 11:27
 */
public class InstructorRepositoryImpl implements InstructorRepository, AutoCloseable {
    EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManager();
    @Override
    public void saveInstructor(Instructor instructor) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateInstructor(Long oldInstructorId, Instructor newInstructor) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, oldInstructorId);
        instructor.setFirstName(newInstructor.getFirstName());
        instructor.setLastName(newInstructor.getLastName());
        instructor.setEmail(newInstructor.getEmail());
        instructor.setPhoneNumber(newInstructor.getPhoneNumber());
        instructor.setCourses(newInstructor.getCourses());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Instructor getInstructorById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructor;
    }

    @Override
    public List<Instructor> getInstructorsByCourseId(Long courseId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, courseId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course.getInstructors();
    }

    @Override
    public void deleteInstructorById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, id);
        for (int i = 0; i < instructor.getCourses().size(); i++) {
            if (instructor.getCourses().get(i).getInstructors().contains(instructor)){
                instructor.getCourses().get(i).getInstructors().remove(instructor);
            }
        }

        entityManager.remove(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void assignInstructorToCourse(Long courseId, Long instructorId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, courseId);
        course.getInstructors().add(entityManager.find(Instructor.class, instructorId));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
