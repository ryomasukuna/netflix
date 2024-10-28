package io.com.movie.model;

import io.com.movie.model.common.AbstractEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "movie_poster")
@Schema(description = "Represents a Poster image entity.")
public class Poster extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "poster_id", nullable = false)
    @Schema(description = "Unique identifier of the poster image.", example = "1", required = true)
    private Long posterId;

    @Schema(description = "URL of the poster image.", example = "https://example.com/poster.jpg", required = true)
    private String imageUrl;

    @ManyToOne
    @Schema(description = "The series this poster belongs to.")
    private Series series;

    @ManyToOne
    @Schema(description = "The season this poster belongs to.")
    private Season season;

    @ManyToOne
    @Schema(description = "The episode this poster belongs to.")
    private Episode episode;

    @ManyToOne
    @Schema(description = "The movie this poster belongs to.")
    private Movie movie;

}