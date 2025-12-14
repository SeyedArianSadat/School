package com.school.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder

@Entity(name = "classroomEntity")
@Table(name = "class_rooms")
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long classroomId;

    private int grade;

    @Column(nullable = false)
    private String classSubject;

    private String zoomLink;

    @ManyToMany(mappedBy = "classrooms")
    private List<Student> students;

    @ManyToMany(mappedBy = "classRooms")
    private List<Teacher> teachers;
}
