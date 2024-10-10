package io.com.movie.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreResponse {
    @Schema(description = "Name of the genre", example = "Science Fiction")
    private String name;

    @Schema(description = "Description of the genre", example = "A genre that uses speculative, fictional science-based depictions...")
    private String description;
}
