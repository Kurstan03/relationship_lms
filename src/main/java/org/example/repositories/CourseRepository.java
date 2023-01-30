package org.example.repositories;

import org.example.entity.Course;

import java.util.List;

/**
 * @author kurstan
 * @created at 27.01.2023 11:26
 */
public interface CourseRepository {
    void saveCourse(Course course);

    Course getCourseById(Long id);

    List<Course> getAllCourse();  //sort by date

    void updateCourse(Long oldCourseId, Course newCourse);

    void deleteCourseById(Long id);

    Course getCourseByName(String courseName);

}
