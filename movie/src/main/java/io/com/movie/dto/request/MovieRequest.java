package io.com.movie.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequest {

    @NotNull
    @Size(min = 1, max = 255)
    @Schema(description = "Title of the movie", example = "Inception")
    private String title;

    @Lob
    @Schema(description = "A synopsis or overview of the movie plot", example = "A skilled thief is offered a chance to have his past crimes forgiven...")
    private String description;

    @PastOrPresent
    @Schema(description = "The release date of the movie", example = "2010-07-16")
    private LocalDate releaseDate;

    @Min(1)
    @Schema(description = "Duration of the movie in minutes", example = "148")
    private int runtimeMinutes;

    @DecimalMin(value = "0.0", inclusive = false, message = "Rating must be between 0 and 10")
    @DecimalMax(value = "10.0", inclusive = true, message = "Rating must be between 0 and 10")
    @Schema(description = "Movie rating (e.g., PG, PG-13, R)", example = "PG-13")
    private String rating;

    @Size(max = 50)
    @Schema(description = "Original language of the movie", example = "English")
    private String language;

    @Size(max = 100)
    @Schema(description = "Country where the movie was produced", example = "USA")
    private String country;

    @Min(0)
    @Schema(description = "Budget in USD", example = "160000000")
    private long budget;

    @Schema(description = "Total box office earnings in USD", example = "829895144")
    private long boxOffice;

    @Schema(description = "URL of the movie’s poster image", example = "https://example.com/poster.jpg")
    private String posterUrl;

    @Schema(description = "URL of the movie’s trailer", example = "https://example.com/trailer.mp4")
    private String trailerUrl;

    @Size(max = 20)
    @Schema(description = "Reference to IMDb ID for external linkage", example = "tt1375666")
    private String imdbId;

    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "100.0", inclusive = true)
    @Schema(description = "Rotten Tomatoes score (0-100 scale)", example = "87.5")
    private double rottenTomatoesScore;

    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "100.0", inclusive = true)
    @Schema(description = "Metacritic score (0-100 scale)", example = "74.2")
    private double metacriticScore;

    @Schema(description = "Foreign key to director (crew table)", example = "1")
    private long directorId;

    @Schema(description = "Foreign key to main genre", example = "1")
    private long mainGenreId;

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

}
