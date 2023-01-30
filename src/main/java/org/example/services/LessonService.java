package org.example.services;

import org.example.entity.Lesson;

import java.util.List;

/**
 * @author kurstan
 * @created at 27.01.2023 11:31
 */
public interface LessonService {
    String saveLesson(Long courseId, Lesson lesson);   //(Lesson сакталып жатканда кандайдыр бир курска сакталуусу керек),

    String updateLesson(Long oldLessonId, Lesson lesson);

    Lesson getLessonById(Long id);

    List<Lesson> getLessonsByCourseId(Long courseId); //(курска тиешелуу сабактарды чыгаруу);

}
