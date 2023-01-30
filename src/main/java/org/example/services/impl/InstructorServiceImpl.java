package org.example.services.impl;

import org.example.config.HibernateConfig;
import org.example.entity.Instructor;
import org.example.repositories.InstructorRepository;
import org.example.repositories.impl.InstructorRepositoryImpl;
import org.example.services.InstructorService;

import java.util.List;

/**
 * @author kurstan
 * @created at 27.01.2023 11:32
 */
public class InstructorServiceImpl implements InstructorService {
    private InstructorRepository instructorRepository = new InstructorRepositoryImpl();
    @Override
    public String saveInstructor(Instructor instructor) {
        instructorRepository.saveInstructor(instructor);
        return instructor.getFirstName() + " is saved!";
    }

    @Override
    public String updateInstructor(Long oldInstructorId, Instructor newInstructor) {
        instructorRepository.updateInstructor(oldInstructorId, newInstructor);
        return newInstructor.getFirstName() + " is updated for id - " + oldInstructorId;
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepository.getInstructorById(id);
    }

    @Override
    public List<Instructor> getInstructorsByCourseId(Long courseId) {
        return instructorRepository.getInstructorsByCourseId(courseId);
    }

    @Override
    public String deleteInstructorById(Long id) {
        instructorRepository.deleteInstructorById(id);
        return "Instructor by id - " + id + " is deleted!";
    }

    @Override
    public String assignInstructorToCourse(Long courseId, Long instructorId) {
        instructorRepository.assignInstructorToCourse(courseId, instructorId);
        return "Instructor by id - " + instructorId + " is assigned to course by id - " + courseId;
    }
}
