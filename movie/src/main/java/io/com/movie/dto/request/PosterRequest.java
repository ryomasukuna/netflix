package io.com.movie.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public class PosterRequest {
    @Schema(description = "URL of the poster image", example = "https://example.com/poster.jpg")
    private String imageUrl;

    @Schema(description = "UUID of the associated series", example = "a123b456-7890-1234-5678-90abcdef1234")
    private UUID seriesId;

    @Schema(description = "ID of the associated season", example = "1")
    private Long seasonId;

    @Schema(description = "ID of the associated episode", example = "1")
    private Long episodeId;
}
