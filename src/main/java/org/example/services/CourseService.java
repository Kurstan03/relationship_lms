package org.example.services;

import org.example.entity.Course;

import java.util.List;

/**
 * @author kurstan
 * @created at 27.01.2023 11:30
 */
public interface CourseService {
    String saveCourse(Course course);

    Course getCourseById(Long id);

    List<Course> getAllCourse();  //sort by date

    String updateCourse(Long oldCourseId, Course newCourse);


    String deleteCourseById(Long id);

    Course getCourseByName(String courseName);

}
