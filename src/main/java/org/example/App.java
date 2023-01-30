package org.example;

import org.example.config.HibernateConfig;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.entity.Lesson;
import org.example.entity.Task;
import org.example.services.CourseService;
import org.example.services.InstructorService;
import org.example.services.LessonService;
import org.example.services.TaskService;
import org.example.services.impl.CourseServiceImpl;
import org.example.services.impl.InstructorServiceImpl;
import org.example.services.impl.LessonServiceImpl;
import org.example.services.impl.TaskServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
//        System.out.println(HibernateConfig.getEntityManager());
        Course course = new Course("Java",9, LocalDate.of(2023,1,26),"images","Back-End");
        Course course1 = new Course("JS",6,LocalDate.of(2023,1,27),"images","Frond-End");
        Course course2 = new Course("Python",5,LocalDate.of(2022,1,27),"images","Back-End");
        Course course3 = new Course("C++",10,LocalDate.of(2023,1,20),"images","Game-dev");

        Instructor instructor = new Instructor("Aijamal", "Asangazieva", "aijamal@email.com", "0550887733");
        Instructor instructor1 = new Instructor("Muhammed", "Asantegin", "muhammed@email.com", "0559344334");
        Instructor instructor2 = new Instructor("Rahim", "Kurbanov", "rahim@email.com", "0223884499");
        Instructor instructor3 = new Instructor("Maksat", "Akyl", "maksat@email.com", "0777882255");
        Instructor instructor4 = new Instructor("Beksultan", "Mamatkadyr uulu", "beksultan@email.com", "0223994488");
        Instructor instructor5 = new Instructor("Chyngyz", "Sharshekeev", "chyngyz@email.com", "0550887733");

        Lesson lesson = new Lesson("Loop","videoLink");
        Lesson lesson1 = new Lesson("Stream","videoLink");
        Lesson lesson2 = new Lesson("Abstraction","videoLink");
        Lesson lesson3 = new Lesson("React", "link");
        Lesson lesson4 = new Lesson("Hibernate relationship","videoLink");

        Task task = new Task("for loop", LocalDateTime.of(2023,1,30,6,30),"task for loop for");
        Task task2 = new Task("while", LocalDateTime.of(2023,1,28,11,0),"task for loop while");
        Task task3 = new Task("Stream", LocalDateTime.of(2023,1,24,22,15),"Collect with stream");
        Task task4 = new Task("Cascade types ", LocalDateTime.of(2023,1,17,10,0),"CascadeType.REFRESH");

//        _______________________________Course commands_____________________________________________
//
//        CourseService courseService = new CourseServiceImpl();
//
//        //1.Save course
//        course.getInstructors().add(instructor);
//        course.getInstructors().add(instructor1);
//        course.getLessons().add(lesson);
//        lesson.setCourse(course);
//        course.getLessons().add(lesson1);
//        lesson1.setCourse(course);
//        System.out.println(courseService.saveCourse(course));
//
//        course1.getInstructors().add(instructor2);
//        course1.getInstructors().add(instructor3);
//        course1.getLessons().add(lesson3);
//        lesson3.setCourse(course1);
//        course1.getLessons().add(lesson4);
//        lesson4.setCourse(course1);
//        System.out.println(courseService.saveCourse(course1));
//
//        System.out.println(courseService.saveCourse(course2));
//
//        //get course by id
//        System.out.println(courseService.getCourseById(2L));
//
//        //get all course sort by date
//        courseService.getAllCourse().forEach(System.out::println);
//
//        //update course
//        System.out.println(courseService.updateCourse(3L, course3));
//
//        //delete course by id
//        System.out.println(courseService.deleteCourseById(2L));
//
//        //get course by id
//        System.out.println(courseService.getCourseByName(course3.getCourseName()));

//        _________________________________Instructor commands_____________________________________
//        InstructorService instructorService = new InstructorServiceImpl();

        //save instructor
//        System.out.println(instructorService.saveInstructor(instructor4));

        //update instructor
//        System.out.println(instructorService.updateInstructor(1L, instructor5));

        //get instructor by id

//        System.out.println(instructorService.getInstructorById(2L));

        //get instructors by course id
//        instructorService.getInstructorsByCourseId(1L).forEach(System.out::println);

        //delete instructor by id
//        System.out.println(instructorService.deleteInstructorById(4L));

        //assign instructor to course
//        System.out.println(instructorService.assignInstructorToCourse(2L, 5L));

//        _________________________________Lesson commands_____________________________________
//        LessonService lessonService = new LessonServiceImpl();

        //save lesson   (Lesson сакталып жатканда кандайдыр бир курска сакталуусу керек)
//        System.out.println(lessonService.saveLesson(1L, lesson2));

        //update lesson
//        System.out.println(lessonService.updateLesson(4L, new Lesson("CSS", "link")));

        //get lesson by id
//        System.out.println(lessonService.getLessonById(3L));

        //get lesson by course id
//        lessonService.getLessonsByCourseId(1L).forEach(System.out::println);

//        _________________________________Task commands_____________________________________


//        TaskService taskService = new TaskServiceImpl();
//        //save task
//        System.out.println(taskService.saveTask(1L, task));

        //update task
//        System.out.println(taskService.updateTask(1L, task2));

        //get all task by lesson id
//        taskService.getAllTaskByLessonId(1L).forEach(System.out::println);

        //delete task
//        System.out.println(taskService.deleteTaskById(1L));
    }
}
