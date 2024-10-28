package io.com.movie.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DirectorRequest {
    @Schema(description = "Name of the director", example = "Christopher Nolan")
    private String name;

    @Schema(description = "Biography of the director", example = "Christopher Nolan is a British-American film director...")
    private String biography;

    @Schema(description = "Date of birth of the director", example = "1970-07-30")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @Schema(description = "Number of awards won by the director", example = "5")
    private int awardCount;

    @Schema(description = "Country of origin of the director", example = "UK")
    private String country;
}
