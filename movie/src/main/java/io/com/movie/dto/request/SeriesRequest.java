package io.com.movie.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request DTO for creating or updating a Series.")
public class SeriesRequest {

    @Schema(description = "Title of the TV series.", example = "Breaking Bad", required = true)
    @NotBlank(message = "Title is mandatory")
    @Size(max = 255, message = "Title must be less than 255 characters")
    private String title;

    @Schema(description = "Description of the TV series.", example = "A high school chemistry teacher turned methamphetamine producer.")
    private String description;

    @Schema(description = "The release date of the first episode.", example = "2008-01-20")
    @PastOrPresent
    private LocalDate releaseDate;

    @Schema(description = "The end date of the series, null if ongoing.", example = "2013-09-29")
    private LocalDate endDate;

    @Schema(description = "Total number of seasons.", example = "5")
    @Min(1)
    private Integer totalSeasons;

    @Schema(description = "Total number of episodes.", example = "62")
    @Min(1)
    private Integer totalEpisodes;

    @NotBlank
    @Schema(description = "Status of the series (e.g., Ongoing, Completed, Canceled).", example = "Completed")
    private String status;

    @Schema(description = "Rating of the series (e.g., TV-MA, TV-PG).", example = "TV-MA")
    private String rating;

    @NotBlank
    @Schema(description = "Original language of the series.", example = "English", required = true)
    private String language;

    @NotBlank
    @Schema(description = "Country where the series was produced.", example = "USA", required = true)
    private String country;

    @Schema(description = "Age certification (e.g., PG, 12A, R18)", example = "PG-13")
    private String ageCertification;

    @Schema(description = "List of trailer URLs for the series.")
    private List<String> trailers;

    @Schema(description = "Whether the series has won awards.", example = "true")
    private boolean hasWonAwards;

    @Schema(description = "Number of awards the series has won.", example = "5")
    private Integer awardCount;

    @Schema(description = "Whether the series is an original production for the platform.", example = "false")
    private boolean isOriginal;

    @Schema(description = "Whether the series is released on a weekly basis.", example = "true")
    private boolean weeklyRelease;
}
