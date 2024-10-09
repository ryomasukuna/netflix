package io.com.movie.model;

import io.com.movie.model.common.AbstractEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "season_series")
public class Season extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the season.", example = "1", required = true)
    @Column(name = "season_id")
    private Long seasonId;

    @ManyToOne
    @JoinColumn(name = "series_id", nullable = false)
    @Schema(description = "The series this season belongs to.", required = true)
    private Series series;


    @Min(1)
    @Schema(description = "The season number.", example = "1", required = true)
    private Integer seasonNumber;

    @NotBlank
    @Size(max = 255)
    @Schema(description = "Title of the season.", example = "Season 1", required = true)
    private String title;

    @PastOrPresent
    @Schema(description = "The release date of the first episode in the season.", example = "2008-01-20")
    private LocalDate releaseDate;

    @Schema(description = "The end date of the season, null if ongoing.", example = "2008-05-10")
    private LocalDate endDate;

    @Min(1)
    @Schema(description = "Number of episodes in the season.", example = "13")
    private Integer totalEpisodes;

    @ElementCollection
    @CollectionTable(name = "season_trailers", joinColumns = @JoinColumn(name = "season_id"))
    @Column(name = "trailer_url")
    @Schema(description = "List of trailer URLs for the season.", example = "[\"https://example.com/trailer1.mp4\", \"https://example.com/trailer2.mp4\"]")
    private List<String> trailers;

    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Schema(description = "List of posters associated with the season.")
    private List<Poster> posters;

    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Schema(description = "List of carousel images associated with the season.")
    private List<CarouselImage> carouselImages;

    @OneToMany(mappedBy = "season")
    @Schema(description = "List of episodes in this season.")
    private List<Episode> episodes;

    @Schema(description = "Whether the season has won awards.", example = "true")
    private boolean hasWonAwards;

    @Schema(description = "Number of awards the season has won.", example = "2")
    private Integer awardCount;

    @Schema(description = "Whether the season is an original production for the platform.", example = "false")
    private boolean isOriginal;


}