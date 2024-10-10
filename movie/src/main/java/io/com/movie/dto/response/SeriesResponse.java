package io.com.movie.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Schema(description = "Response DTO for Series.")
public class SeriesResponse {

    @Schema(description = "Unique ID of the series.", example = "f8a830f4-e2d2-11eb-ba80-0242ac130004")
    private UUID seriesId;

    @Schema(description = "Title of the TV series.", example = "Breaking Bad")
    private String title;

    @Schema(description = "Description of the TV series.")
    private String description;

    @Schema(description = "The release date of the first episode.", example = "2008-01-20")
    private LocalDate releaseDate;

    @Schema(description = "The end date of the series, null if ongoing.", example = "2013-09-29")
    private LocalDate endDate;

    @Schema(description = "Total number of seasons.", example = "5")
    private Integer totalSeasons;

    @Schema(description = "Total number of episodes.", example = "62")
    private Integer totalEpisodes;

    @Schema(description = "Status of the series (e.g., Ongoing, Completed, Canceled).", example = "Completed")
    private String status;

    @Schema(description = "Rating of the series (e.g., TV-MA, TV-PG).", example = "TV-MA")
    private String rating;

    @Schema(description = "Original language of the series.", example = "English")
    private String language;

    @Schema(description = "Country where the series was produced.", example = "USA")
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
