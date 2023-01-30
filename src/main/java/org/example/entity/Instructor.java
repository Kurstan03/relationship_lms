package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kurstan
 * @created at 27.01.2023 11:24
 */
@Entity
@Table(name = "instructors")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "courses")
public class Instructor {
    @Id
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "instructor_id_generator"
    )
    @SequenceGenerator(
            name = "instructor_id_generator",
            sequenceName = "instructor_seq",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "instructors",
    cascade = {CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH}
    )
    private List<Course> courses = new LinkedList<>();

    public Instructor(String firstName, String lastName, String email,
                      String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
