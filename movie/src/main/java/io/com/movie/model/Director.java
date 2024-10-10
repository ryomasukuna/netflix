package io.com.movie.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "director")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "director_id", unique = true, nullable = false)
    @Schema(description = "UUID Primary key (Unique identifier for the director)", example = "f47ac10b-58cc-4372-a567-0e02b2c3d480")
    private Long directorId;

    @Schema(description = "Name of the director", example = "Christopher Nolan")
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Schema(description = "Biography of the director", example = "Christopher Nolan is a British-American film director...")
    @Column(name = "biography", columnDefinition = "TEXT")
    private String biography;

    @Schema(description = "Date of birth of the director", example = "1970-07-30")
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;

    @Schema(description = "Number of awards won by the director", example = "5")
    @Column(name = "award_count")
    private int awardCount;

    @Schema(description = "Country of origin of the director", example = "UK")
    @Column(name = "country", length = 50)
    private String country;

    @OneToMany(mappedBy = "director")
    private List<Movie> movies;

    @OneToMany(mappedBy = "director")
    private List<Series> series;

}