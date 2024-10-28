package io.com.movie.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "movie_genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id", nullable = false)
    private Long genreId;

    @Schema(description = "Name of the genre", example = "Science Fiction")
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Schema(description = "Description of the genre", example = "A genre that uses speculative, fictional science-based depictions...")
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToMany(mappedBy = "genres")
    @Schema(description = "List of movies associated with this genre")
    private List<Movie> movies;

    @ManyToMany(mappedBy = "genres")
    @Schema(description = "List of series associated with this genre")
    private List<Series> series;

}