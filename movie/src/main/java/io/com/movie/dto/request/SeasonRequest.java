package io.com.movie.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class SeasonRequest {
    @Schema(description = "UUID of the associated series", example = "a123b456-7890-1234-5678-90abcdef1234")
    private UUID seriesId;

    @Schema(description = "Season number", example = "1")
    private Integer seasonNumber;

    @Schema(description = "Title of the season", example = "Season 1")
    private String title;

    @Schema(description = "Release date of the season", example = "2024-01-01")
    private LocalDate releaseDate;

    @Schema(description = "End date of the season", example = "2024-12-31")
    private LocalDate endDate;

    @Schema(description = "Total episodes in the season", example = "10")
    private Integer totalEpisodes;

    @Schema(description = "List of trailers for the season", example = "[\"trailer1.mp4\", \"trailer2.mp4\"]")
    private List<String> trailers;

    @Schema(description = "Has the season won any awards", example = "false")
    private boolean hasWonAwards;

    @Schema(description = "Number of awards the season has won", example = "0")
    private Integer awardCount;

    @Schema(description = "Is the season an original", example = "true")
    private boolean isOriginal;
}
