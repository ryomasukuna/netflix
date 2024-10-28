package io.com.movie.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Getter
@Setter
public class MovieResponse {

    @Schema(description = "UUID Primary key (Unique identifier for the movie)", example = "f47ac10b-58cc-4372-a567-0e02b2c3d479")
    private UUID id;

    @Schema(description = "Title of the movie", example = "Inception")
    private String title;

    @Schema(description = "A synopsis or overview of the movie plot", example = "A skilled thief is offered a chance to have his past crimes forgiven...")
    private String description;

    @Schema(description = "The release date of the movie", example = "2010-07-16")
    private LocalDate releaseDate;

    @Schema(description = "Duration of the movie in minutes", example = "148")
    private int runtimeMinutes;

    @Schema(description = "Movie rating (e.g., PG, PG-13, R)", example = "PG-13")
    private String rating;

    @Schema(description = "Original language of the movie", example = "English")
    private String language;

    @Schema(description = "Country where the movie was produced", example = "USA")
    private String country;

    @Schema(description = "Budget in USD", example = "160000000")
    private long budget;

    @Schema(description = "Total box office earnings in USD", example = "829895144")
    private long boxOffice;

    @Schema(description = "URL of the movie’s poster image", example = "https://example.com/poster.jpg")
    private String posterUrl;

    @Schema(description = "URL of the movie’s trailer", example = "https://example.com/trailer.mp4")
    private String trailerUrl;

    @Schema(description = "Reference to IMDb ID for external linkage", example = "tt1375666")
    private String imdbId;

    @Schema(description = "Rotten Tomatoes score (0-100 scale)", example = "87.5")
    private double rottenTomatoesScore;

    @Schema(description = "Metacritic score (0-100 scale)", example = "74.2")
    private double metacriticScore;

    @Schema(description = "Foreign key to director (crew table)", example = "1")
    private UUID directorId;

    @Schema(description = "Foreign key to production companies", example = "1")
    private long productionCompanyId;

    @Schema(description = "Age certification (e.g., PG, 12A, R18)", example = "PG-13")
    private String ageCertification;

    @Schema(description = "Whether the movie has won any awards", example = "true")
    private boolean hasWonAwards;

    @Schema(description = "Number of awards the movie has won", example = "4")
    private int awardCount;

    @Schema(description = "Whether the movie is an original production", example = "false")
    private boolean isOriginal;

    @Schema(description = "Whether the movie is available in HD", example = "true")
    private boolean hdAvailable;

    @Schema(description = "Whether the movie is available in 4K", example = "true")
    private boolean fourKAvailable;

    private Set<UUID> actorIds;

    private List<UUID> genreIds;
}
