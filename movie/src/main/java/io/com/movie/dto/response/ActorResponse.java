package io.com.movie.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ActorResponse {
    @Schema(description = "UUID Primary key (Unique identifier for the actor)", example = "1")
    private Long id;

    @Schema(description = "Name of the actor", example = "Leonardo DiCaprio")
    private String name;

    @Schema(description = "Biography of the actor", example = "Leonardo Wilhelm DiCaprio is an American actor...")
    private String biography;

    @Schema(description = "Date of birth of the actor", example = "1974-11-11")
    private LocalDate dateOfBirth;

    @Schema(description = "Number of awards won by the actor", example = "1")
    private int awardCount;

    @Schema(description = "Country of origin of the actor", example = "USA")
    private String country;

    @Schema(description = "List of movies the actor has appeared in")
    private List<MovieResponse> movies;

    @Schema(description = "List of series the actor has appeared in")
    private List<SeriesResponse> series;
}
