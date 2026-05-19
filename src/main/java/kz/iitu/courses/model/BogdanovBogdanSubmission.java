package kz.iitu.courses.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Table(name = "submissions")
@Getter
@Setter
public class BogdanovBogdanSubmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "assignment_id")
    private BogdanovBogdanAssignment assignment;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id")
    private BogdanovBogdanUser student;

    @ManyToOne
    @JoinColumn(name = "file_asset_id")
    private BogdanovBogdanFileAsset fileAsset;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BogdanovBogdanSubmissionStatus status;

    @Column(nullable = false)
    private OffsetDateTime submittedAt;
}
