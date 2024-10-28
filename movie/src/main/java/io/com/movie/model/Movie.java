package io.com.movie.model;

import io.com.movie.model.common.AbstractEntity;
import io.com.movie.model.enums.AgeCertification;
import io.com.movie.utils.ValidatorEnumClass;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "movie_movies")
@Data
@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Schema(description = "Represents a movie entity.")
public class Movie extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(description = "UUID Primary key (Unique identifier for the movie)", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    @Column(name = "movie_id", unique = true, nullable = false)
    private UUID movieId;

    @NotNull
    @Size(min = 1, max = 255)
    @Schema(description = "Title of the movie", example = "Inception")
    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Schema(description = "A synopsis or overview of the movie plot", example = "A skilled thief is offered a chance to have his past crimes forgiven...")
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @PastOrPresent
    @Schema(description = "The release date of the movie", example = "2010-07-16")
    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    private LocalDate releaseDate;

    @Min(1)
    @Schema(description = "Duration of the movie in minutes", example = "148")
    @Column(name = "runtime_minutes")
    private int runtimeMinutes;

    @DecimalMin(value = "0.0", inclusive = false, message = "Rating must be between 0 and 10")
    @DecimalMax(value = "10.0", inclusive = true, message = "Rating must be between 0 and 10")
    @Schema(description = "Movie rating (e.g., PG, PG-13, R)", example = "PG-13")
    @Column(name = "rating", precision = 5, scale = 2)
    private BigDecimal rating;

    @Size(max = 50)
    @Schema(description = "Original language of the movie", example = "English")
    @Column(name = "language", length = 50)
    private String language;

    @Size(max = 100)
    @Schema(description = "Country where the movie was produced", example = "USA")
    @Column(name = "country", length = 100)
    private String country;

    @Min(0)
    @Schema(description = "Budget in USD", example = "160000000")
    @Column(name = "budget")
    private long budget;

    @Schema(description = "Total box office earnings in USD", example = "829895144")
    @Column(name = "box_office")
    private long boxOffice;

    @Schema(description = "URL of the movie’s poster image", example = "https://example.com/poster.jpg")
    @Column(name = "poster_url", length = 500)
    private String posterUrl;

    @Schema(description = "URL of the movie’s trailer", example = "https://example.com/trailer.mp4")
    @Column(name = "trailer_url", length = 500)
    private String trailerUrl;

    @Size(max = 20)
    @Schema(description = "Reference to IMDb ID for external linkage", example = "tt1375666")
    @Column(name = "imdb_id", length = 20)
    private String imdbId;

    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "100.0", inclusive = true)
    @Schema(description = "Rotten Tomatoes score (0-100 scale)", example = "87.5")
    @Column(name = "rotten_tomatoes_score", precision = 3, scale = 1)
    private BigDecimal rottenTomatoesScore;

    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "100.0", inclusive = true)
    @Schema(description = "Metacritic score (0-100 scale)", example = "74.2")
    @Column(name = "metacritic_score", precision = 3, scale = 1)
    private BigDecimal metacriticScore;

    @Schema(description = "Age certification (e.g., PG, 12A, R18)", example = "PG-13")
    @Column(name = "age_certification", length = 10)
    @ValidatorEnumClass(enumClass = AgeCertification.class, message = "Invalid Age Certification, must be any of {value}", name = "ageCertification")
    private AgeCertification ageCertification;

    @Schema(description = "Whether the movie has won any awards", example = "true")
    @Column(name = "has_won_awards")
    private boolean hasWonAwards;

    @Schema(description = "Number of awards the movie has won", example = "4")
    @Column(name = "award_count")
    private int awardCount;

    @Schema(description = "Whether the movie is an original production", example = "false")
    @Column(name = "is_original")
    private boolean isOriginal;

    @Schema(description = "Whether the movie is available in HD", example = "true")
    @Column(name = "hd_available")
    private boolean hdAvailable;

    @Schema(description = "Whether the movie is available in 4K", example = "true")
    @Column(name = "4k_available")
    private boolean fourKAvailable;

    @ManyToOne
    @JoinColumn(name = "director_id")
    @Schema(description = "Foreign key to director", example = "1")
    private Director director;

    @ManyToOne
    @JoinColumn(name = "main_actor_id")
    @Schema(description = "Foreign key to the main actor", example = "1")
    private Actor mainActor;

    @ElementCollection
    @CollectionTable(name = "movie_series_trailers", joinColumns = @JoinColumn(name = "series_id"))
    @Column(name = "trailer_url")
    @Schema(description = "List of trailer URLs for the series.", example = "[\"https://example.com/trailer1.mp4\", \"https://example.com/trailer2.mp4\"]")
    private List<String> trailers;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Schema(description = "List of posters associated with the movie.")
    private List<Poster> posters;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @Schema(description = "List of carousel images associated with the movie.")
    private List<CarouselImage> carouselImages;

    @ManyToMany
    @JoinTable(
            name = "movie_actor_relationship",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    @Schema(description = "Foreign key to main genre", example = "1")
    private Set<Actor> actors;

    @ManyToMany
    @JoinTable(
            name = "movie_genres_relationship",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    @Schema(description = "List of genres associated with this movie")
    private List<Genre> genres;

}
