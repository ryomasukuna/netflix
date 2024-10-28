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

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "movie_episode")
@Schema(description = "Represents an Episode entity.")
public class Episode extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "episode_id", nullable = false)
    @Schema(description = "Unique identifier of the episode.", example = "1", required = true)
    private UUID episodeId;

    @ManyToOne
    @JoinColumn(name = "season_id")
    @Schema(description = "The season this episode belongs to.", required = true)
    private Season season;

    @Min(1)
    @Schema(description = "The episode number within the season.", example = "1", required = true)
    private Integer episodeNumber;

    @NotBlank
    @Size(max = 255)
    @Schema(description = "Title of the episode.", example = "Pilot", required = true)
    private String title;

    @Lob
    @Schema(description = "Description of the episode.", example = "Walter White, a high school chemistry teacher, starts cooking meth.")
    private String description;

    @PastOrPresent
    @Schema(description = "Release date of the episode.", example = "2008-01-20")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Min(1)
    @Schema(description = "Length of the episode in minutes.", example = "45")
    private Integer runtimeMinutes;

    @Schema(description = "Whether the episode has won awards.", example = "true")
    private boolean hasWonAwards;

    @Schema(description = "Number of awards the episode has won.", example = "1")
    private Integer awardCount;

    @ElementCollection
    @CollectionTable(name = "movie_episode_trailers", joinColumns = @JoinColumn(name = "episode_id"))
    @Column(name = "trailer_url")
    @Schema(description = "List of trailer URLs for the episode.", example = "[\"https://example.com/trailer1.mp4\", \"https://example.com/trailer2.mp4\"]")
    private List<String> trailers;

    @OneToMany(mappedBy = "episode", cascade = CascadeType.ALL)
    @Schema(description = "List of posters associated with the episode.")
    private List<Poster> posters;

    @Schema(description = "Rating of the episode (e.g., TV-MA, TV-PG).", example = "TV-MA")
    private String rating;

    @Min(0)
    @Schema(description = "Number of viewers for the episode.", example = "1500000")
    private Long viewership;


}