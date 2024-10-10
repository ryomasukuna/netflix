package io.com.movie.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class CarouselImageRequest {

    @Schema(description = "URL of the carousel image", example = "https://example.com/image.jpg")
    private String imageUrl;

    @Schema(description = "UUID of the associated series", example = "a123b456-7890-1234-5678-90abcdef1234")
    private UUID seriesId;

    @Schema(description = "ID of the associated season", example = "1")
    private Long seasonId;

    @Schema(description = "ID of the associated episode", example = "1")
    private Long episodeId;

}