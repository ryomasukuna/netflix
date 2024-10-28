package io.com.movie.model;

import io.com.movie.model.enums.Gender;
import io.com.movie.utils.ValidatorEnumClass;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "movie_actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id", nullable = false)
    private Long actorId;

    @Schema(description = "Name of the actor", example = "Leonardo DiCaprio")
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Schema(description = "Biography of the actor", example = "Leonardo Wilhelm DiCaprio is an American actor...")
    @Column(name = "biography", columnDefinition = "TEXT")
    private String biography;

    @Schema(description = "Biography of the actor", example = "Leonardo Wilhelm DiCaprio is an American actor...")
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @ValidatorEnumClass(enumClass = Gender.class, message = "Invalid Gender, must be any of {value}", name = "gender")
    private Gender gender;

    @Schema(description = "Date of birth of the actor", example = "1974-11-11")
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;

    @Schema(description = "Number of awards won by the actor", example = "1")
    @Column(name = "award_count")
    private int awardCount;

    @Schema(description = "Country of origin of the actor", example = "USA")
    @Column(name = "country", length = 50)
    private String country;

    @ManyToMany(mappedBy = "actors")
    private Set<Movie> movies;

    @ManyToMany(mappedBy = "actors")
    private Set<Series> series;


}