package io.com.movie.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarouselImageResponse {

    @Schema(description = "ID of the carousel image", example = "1")
    private Long carouselImageId;

    @Schema(description = "URL of the carousel image", example = "https://example.com/image.jpg")
    private String imageUrl;

}
