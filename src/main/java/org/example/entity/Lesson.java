package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

/**
 * @author kurstan
 * @created at 27.01.2023 11:24
 */
@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"course", "tasks"})
public class Lesson {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "lesson_id_generator"
    )
    @SequenceGenerator(
            name = "lesson_id_generator",
            sequenceName = "lesson_seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    @Column(name = "video_link")
    private String videoLink;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            })
    private List<Task> tasks = new LinkedList<>();

    public Lesson(String name, String videoLink) {
        this.name = name;
        this.videoLink = videoLink;
    }

//    @Override
//    public String toString() {
//        return "Lesson{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", videoLink='" + videoLink + '\'' +
//                '}';
//    }
}
