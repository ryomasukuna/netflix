package io.com.movie.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class DirectorResponse {
    @Schema(description = "UUID Primary key (Unique identifier for the director)", example = "f47ac10b-58cc-4372-a567-0e02b2c3d480")
    private Long directorId;

    @Schema(description = "Name of the director", example = "Christopher Nolan")
    private String name;

    @Schema(description = "Biography of the director", example = "Christopher Nolan is a British-American film director...")
    private String biography;

    @Schema(description = "Date of birth of the director", example = "1970-07-30")
    private LocalDate dateOfBirth;

    @Schema(description = "Number of awards won by the director", example = "5")
    private int awardCount;

    @Schema(description = "Country of origin of the director", example = "UK")
    private String country;

    @Schema(description = "List of movies directed by the director")
    private List<MovieResponse> movies;

    @Schema(description = "List of series directed by the director")
    private List<SeriesResponse> series;
}
