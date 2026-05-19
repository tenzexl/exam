package kz.iitu.courses.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Table(name = "file_assets")
@Getter
@Setter
public class BogdanovBogdanFileAsset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String originalName;

    @Column(nullable = false, unique = true)
    private String storedName;

    private String contentType;

    @Column(nullable = false)
    private long size;

    @Column(nullable = false)
    private OffsetDateTime uploadedAt;
}
