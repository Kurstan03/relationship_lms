package org.example.services;

import org.example.entity.Instructor;

import java.util.List;

/**
 * @author kurstan
 * @created at 27.01.2023 11:30
 */
public interface InstructorService {
    String saveInstructor(Instructor instructor);

    String updateInstructor(Long oldInstructorId, Instructor newInstructor);

    Instructor getInstructorById(Long id);

    List<Instructor> getInstructorsByCourseId(Long courseId);

    String deleteInstructorById(Long id);   //(инструктор очкондо, инструкторго тиешелуу курс очпошу керек),

    String assignInstructorToCourse(Long courseId, Long instructorId); //(инструкторду курска кошуп коюу(назначить)).

}
