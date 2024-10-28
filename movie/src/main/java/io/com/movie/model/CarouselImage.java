package io.com.movie.model;

import io.com.movie.model.common.AbstractEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "movie_carousel_image")
@Schema(description = "Represents a Carousel image entity.")
public class CarouselImage extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carousel_image_id", nullable = false)
    private UUID carouselImageId;

    @Schema(description = "URL of the carousel image.", example = "https://example.com/carousel.jpg", required = true)
    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @ManyToOne
    @Schema(description = "The series this carousel image belongs to.")
    private Series series;

    @ManyToOne
    @Schema(description = "The movie this carousel image belongs to.")
    private Movie movie;

}