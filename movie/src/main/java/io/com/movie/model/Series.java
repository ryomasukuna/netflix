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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "movie_series")
@Schema(description = "Represents a TV Series entity.")
public class Series extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "series_id")
    private UUID seriesId;

    @NotBlank(message = "Title is mandatory")
    @Size(max = 255, message = "Title must be less than 255 characters")
    @Schema(description = "Title of the TV series.", example = "Breaking Bad", required = true)
    private String title;

    @Schema(description = "Description of the TV series.", example = "A high school chemistry teacher turned methamphetamine producer.")
    @Lob
    private String description;

    @PastOrPresent
    @Schema(description = "The release date of the first episode.", example = "2008-01-20")
    private LocalDate releaseDate;

    @Schema(description = "The end date of the series, null if ongoing.", example = "2013-09-29")
    private LocalDate endDate;

    @Min(1)
    @Schema(description = "Total number of seasons.", example = "5")
    private Integer totalSeasons;

    @Min(1)
    @Schema(description = "Total number of episodes.", example = "62")
    private Integer totalEpisodes;

    @NotBlank
    @Schema(description = "Status of the series (e.g., Ongoing, Completed, Canceled).", example = "Completed")
    private String status;

    @Schema(description = "Rating of the series (e.g., TV-MA, TV-PG).", example = "TV-MA")
    private String rating;

    @Schema(description = "Rotten Tomatoes score (0-100 scale)", example = "87.5")
    @Column(name = "rotten_tomatoes_score", precision = 3, scale = 1)
    private BigDecimal rottenTomatoesScore;

    @Schema(description = "Metacritic score (0-100 scale)", example = "74.2")
    @Column(name = "metacritic_score", precision = 3, scale = 1)
    private BigDecimal metacriticScore;

    @NotBlank
    @Schema(description = "Original language of the series.", example = "English", required = true)
    private String language;

    @NotBlank
    @Schema(description = "Country where the series was produced.", example = "USA", required = true)
    private String country;

    @Schema(description = "Age certification (e.g., PG, 12A, R18)", example = "PG-13")
    @Column(name = "age_certification", length = 10)
    private String ageCertification;

    @Schema(description = "Whether the series has won awards.", example = "true")
    private boolean hasWonAwards;

    @Schema(description = "Number of awards the series has won.", example = "5")
    private Integer awardCount;

    @Schema(description = "Whether the series is an original production for the platform.", example = "false")
    private boolean isOriginal;

    @Schema(description = "Whether the series is released on a weekly basis.", example = "true")
    private boolean weeklyRelease;

    @ManyToOne
    @JoinColumn(name = "director_id")
    @Schema(description = "Foreign key to director (crew table)", example = "1")
    private Director director;

    @Schema(description = "Foreign key to main genre", example = "1")
    @ManyToOne
    @JoinColumn(name = "main_actor_id")
    private Actor mainActor;

    @ElementCollection
    @CollectionTable(name = "movie_series_trailers", joinColumns = @JoinColumn(name = "series_id"))
    @Column(name = "trailer_url")
    @Schema(description = "List of trailer URLs for the series.", example = "[\"https://example.com/trailer1.mp4\", \"https://example.com/trailer2.mp4\"]")
    private List<String> trailers;

    @OneToMany(mappedBy = "series", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Schema(description = "List of posters associated with the series.")
    private List<Poster> posters;

    @OneToMany(mappedBy = "series", cascade = CascadeType.ALL)
    @Schema(description = "List of carousel images associated with the series.")
    private List<CarouselImage> carouselImages;

    @OneToMany(mappedBy = "series")
    @Schema(description = "List of seasons that belong to this series.")
    private List<Season> seasons;

    @ManyToMany
    @Schema(description = "Foreign key to main actor", example = "1")
    @JoinTable(
            name = "movie_series_actors_relationship",
            joinColumns = @JoinColumn(name = "series_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> actors;

    @ManyToMany
    @JoinTable(
            name = "movie_series_genres_relationship",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "series_id")
    )
    @Schema(description = "List of genres associated with this series")
    private List<Genre> genres;

}
