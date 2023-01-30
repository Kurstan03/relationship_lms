package org.example.services.impl;

import org.example.entity.Course;
import org.example.repositories.CourseRepository;
import org.example.repositories.impl.CourseRepositoryImpl;
import org.example.services.CourseService;

import java.util.List;

/**
 * @author kurstan
 * @created at 27.01.2023 11:31
 */
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository = new CourseRepositoryImpl();

    @Override
    public String saveCourse(Course course) {
        courseRepository.saveCourse(course);
        return course.getCourseName() + " is saved!";
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.getAllCourse();
    }

    @Override
    public String updateCourse(Long oldCourseId, Course newCourse) {
        courseRepository.updateCourse(oldCourseId, newCourse);
        return newCourse.getCourseName() + " is updated for id - " +oldCourseId;
    }

    @Override
    public String deleteCourseById(Long id) {
        courseRepository.deleteCourseById(id);
        return "Course by id - " + id +  " is deleted!";
    }

    @Override
    public Course getCourseByName(String courseName) {
        return courseRepository.getCourseByName(courseName);
    }
}
