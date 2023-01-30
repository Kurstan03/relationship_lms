package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author kurstan
 * @created at 27.01.2023 11:24
 */
@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Task {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_id_generator"
    )
    @SequenceGenerator(
            name = "task_id_generator",
            sequenceName = "task_seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    @Column(name = "dead_line")
    private LocalDateTime deadLine;
    private String task;

    public Task(String name, LocalDateTime deadLine, String task) {
        this.name = name;
        this.deadLine = deadLine;
        this.task = task;
    }
}
