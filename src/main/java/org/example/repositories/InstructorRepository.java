package org.example.repositories;

import org.example.entity.Instructor;

import java.util.List;

/**
 * @author kurstan
 * @created at 27.01.2023 11:28
 */
public interface InstructorRepository {
    void saveInstructor(Instructor instructor);

    void updateInstructor(Long oldInstructorId, Instructor newInstructor);

    Instructor getInstructorById(Long id);

    List<Instructor> getInstructorsByCourseId(Long courseId);

    void deleteInstructorById(Long id);   //(инструктор очкондо, инструкторго тиешелуу курс очпошу керек),

    void assignInstructorToCourse(Long courseId, Long instructorId); //(инструкторду курска кошуп коюу(назначить)).


}
