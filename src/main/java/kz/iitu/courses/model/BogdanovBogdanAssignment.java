package kz.iitu.courses.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Table(name = "assignments")
@Getter
@Setter
public class BogdanovBogdanAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id")
    private BogdanovBogdanCourse course;

    @Column(nullable = false)
    private String title;

    @Column(length = 2000)
    private String description;

    private OffsetDateTime dueDate;
}
