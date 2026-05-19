package kz.iitu.courses.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Table(name = "enrollments")
@Getter
@Setter
public class BogdanovBogdanEnrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id")
    private BogdanovBogdanUser student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id")
    private BogdanovBogdanCourse course;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BogdanovBogdanEnrollmentStatus status;

    @Column(nullable = false)
    private OffsetDateTime enrolledAt;
}
