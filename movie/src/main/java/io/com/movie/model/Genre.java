package io.com.movie.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "genre")
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

    @ManyToMany
    @JoinTable(
            name = "movie_genres",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    @Schema(description = "List of movies associated with this genre")
    private List<Movie> movies;

    @ManyToMany
    @JoinTable(
            name = "series_genres",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "series_id")
    )
    @Schema(description = "List of series associated with this genre")
    private List<Series> series;

}