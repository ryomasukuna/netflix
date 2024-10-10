package io.com.movie.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class EpisodeRequest {

    @Schema(description = "ID of the season", example = "1")
    private Long seasonId;

    @Schema(description = "Episode number", example = "1")
    private Integer episodeNumber;

    @Schema(description = "Title of the episode", example = "Pilot")
    private String title;

    @Schema(description = "Description of the episode", example = "The beginning of an epic journey.")
    private String description;

    @Schema(description = "Release date of the episode", example = "2024-01-01")
    private Date releaseDate;

    @Schema(description = "Runtime in minutes", example = "45")
    private Integer runtimeMinutes;

    @Schema(description = "Has the episode won any awards", example = "false")
    private boolean hasWonAwards;

    @Schema(description = "Number of awards the episode has won", example = "0")
    private Integer awardCount;

    @Schema(description = "List of trailers for the episode", example = "[\"trailer1.mp4\", \"trailer2.mp4\"]")
    private List<String> trailers;

    @Schema(description = "Rating of the episode", example = "8.5")
    private String rating;

    @Schema(description = "Viewership of the episode", example = "5000000")
    private Long viewership;

}
