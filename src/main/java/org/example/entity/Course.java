package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kurstan
 * @created at 27.01.2023 11:24
 */
@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"instructors", "lessons"})
public class Course {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_id_generator"
    )
    @SequenceGenerator(
            name = "course_id_generator",
            sequenceName = "course_seq",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "course_name")
    private String courseName;
    private Integer duration;
    @Column(name = "create_at")
    private LocalDate createAt;
    @Column(name = "image_link")
    private String imageLink;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    @JoinTable(
        name = "instructors_courses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "instructor_id")
    )
    private List<Instructor> instructors = new LinkedList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course", cascade = CascadeType.ALL)
    private List<Lesson> lessons = new LinkedList<>();

    public Course(String courseName, Integer duration, LocalDate createAt, String imageLink,
                  String description) {
        this.courseName = courseName;
        this.duration = duration;
        this.createAt = createAt;
        this.imageLink = imageLink;
        this.description = description;
    }

//    @Override
//    public String toString() {
//        return "Course{" +
//                "id=" + id +
//                ", courseName='" + courseName + '\'' +
//                ", duration=" + duration +
//                ", createAt=" + createAt +
//                ", imageLink='" + imageLink + '\'' +
//                ", description='" + description + '\'' +
//                '}';
//    }
}
