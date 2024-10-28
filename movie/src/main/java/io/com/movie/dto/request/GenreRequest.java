package io.com.movie.dto.request;

import io.com.movie.dto.response.MovieResponse;
import io.com.movie.dto.response.SeriesResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenreRequest {
    @Schema(description = "UUID Primary key (Unique identifier for the genre)", example = "1")
    private Long genreId;

    @Schema(description = "Name of the genre", example = "Science Fiction")
    private String name;

    @Schema(description = "Description of the genre", example = "A genre that uses speculative, fictional science-based depictions...")
    private String description;

    @Schema(description = "List of movies associated with this genre")
    private List<MovieResponse> movies;

    @Schema(description = "List of series associated with this genre")
    private List<SeriesResponse> series;
}
