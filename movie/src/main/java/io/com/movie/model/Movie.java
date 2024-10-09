package io.com.movie.model;

import io.com.movie.model.common.AbstractEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "movies")
@Schema(description = "Represents a movie entity.")
public class Movie extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(description = "UUID Primary key (Unique identifier for the movie)", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    @Column(name = "id", unique = true, nullable = false)
    private UUID id;

    @Schema(description = "Title of the movie", example = "Inception")
    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Schema(description = "A synopsis or overview of the movie plot", example = "A skilled thief is offered a chance to have his past crimes forgiven...")
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Schema(description = "The release date of the movie", example = "2010-07-16")
    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    private LocalDate releaseDate;

    @Schema(description = "Duration of the movie in minutes", example = "148")
    @Column(name = "runtime_minutes")
    private int runtimeMinutes;

    @Schema(description = "Movie rating (e.g., PG, PG-13, R)", example = "PG-13")
    @Column(name = "rating", length = 10)
    private String rating;

    @Schema(description = "Original language of the movie", example = "English")
    @Column(name = "language", length = 50)
    private String language;

    @Schema(description = "Country where the movie was produced", example = "USA")
    @Column(name = "country", length = 100)
    private String country;

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

    @Schema(description = "Reference to IMDb ID for external linkage", example = "tt1375666")
    @Column(name = "imdb_id", length = 20)
    private String imdbId;

    @Schema(description = "Rotten Tomatoes score (0-100 scale)", example = "87.5")
    @Column(name = "rotten_tomatoes_score", precision = 3, scale = 1)
    private double rottenTomatoesScore;

    @Schema(description = "Metacritic score (0-100 scale)", example = "74.2")
    @Column(name = "metacritic_score", precision = 3, scale = 1)
    private double metacriticScore;

    @Schema(description = "Foreign key to director (crew table)", example = "1")
    @Column(name = "director_id")
    private long directorId;

    @Schema(description = "Foreign key to production companies", example = "1")
    @Column(name = "production_company_id")
    private long productionCompanyId;

    @Schema(description = "Foreign key to main genre", example = "1")
    @Column(name = "main_genre_id")
    private long mainGenreId;

    @Schema(description = "Age certification (e.g., PG, 12A, R18)", example = "PG-13")
    @Column(name = "age_certification", length = 10)
    private String ageCertification;

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

}
