package io.com.movie.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id", nullable = false)
    private Long actorId;

    @Schema(description = "Name of the actor", example = "Leonardo DiCaprio")
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Schema(description = "Biography of the actor", example = "Leonardo Wilhelm DiCaprio is an American actor...")
    @Column(name = "biography", columnDefinition = "TEXT")
    private String biography;

    @Schema(description = "Date of birth of the actor", example = "1974-11-11")
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;

    @Schema(description = "Number of awards won by the actor", example = "1")
    @Column(name = "award_count")
    private int awardCount;

    @Schema(description = "Country of origin of the actor", example = "USA")
    @Column(name = "country", length = 50)
    private String country;

    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;

    @ManyToMany(mappedBy = "actors")
    private List<Series> series;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

}