package io.com.movie.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ActorRequest {
    @Schema(description = "Name of the actor", example = "Leonardo DiCaprio")
    private String name;

    @Schema(description = "Biography of the actor", example = "Leonardo Wilhelm DiCaprio is an American actor...")
    private String biography;

    @Schema(description = "Date of birth of the actor", example = "1974-11-11")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @Schema(description = "Number of awards won by the actor", example = "1")
    private int awardCount;

    @Schema(description = "Country of origin of the actor", example = "USA")
    private String country;
}
