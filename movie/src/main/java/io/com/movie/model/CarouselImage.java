package io.com.movie.model;

import io.com.movie.model.common.AbstractEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "carousel_image")
@Schema(description = "Represents a Carousel image entity.")
public class CarouselImage extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carousel_image_id", nullable = false)
    private Long carouselImageId;

    @Schema(description = "URL of the carousel image.", example = "https://example.com/carousel.jpg", required = true)
    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "series_id")
    @Schema(description = "The series this carousel image belongs to.")
    private Series series;

    @ManyToOne
    @JoinColumn(name = "season_id")
    @Schema(description = "The season this carousel image belongs to.")
    private Season season;

    @ManyToOne
    @JoinColumn(name = "episode_id")
    @Schema(description = "The episode this carousel image belongs to.")
    private Episode episode;


}