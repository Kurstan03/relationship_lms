package org.example.services.impl;

import org.example.entity.Lesson;
import org.example.repositories.LessonRepository;
import org.example.repositories.impl.LessonRepositoryImpl;
import org.example.services.LessonService;

import java.util.List;

/**
 * @author kurstan
 * @created at 27.01.2023 11:32
 */
public class LessonServiceImpl implements LessonService {
    private LessonRepository lessonRepository = new LessonRepositoryImpl();

    @Override
    public String saveLesson(Long courseId, Lesson lesson) {
        lessonRepository.saveLesson(courseId, lesson);
        return "Lesson "  + lesson.getName() + " is saved!";
    }

    @Override
    public String updateLesson(Long oldLessonId, Lesson lesson) {
        lessonRepository.updateLesson(oldLessonId, lesson);
        return "Lesson " + lesson.getName() + " is updated!";
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonRepository.getLessonById(id);
    }

    @Override
    public List<Lesson> getLessonsByCourseId(Long courseId) {
        return lessonRepository.getLessonsByCourseId(courseId);
    }
}
