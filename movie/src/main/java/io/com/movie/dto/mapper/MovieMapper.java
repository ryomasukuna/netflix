package io.com.movie.dto.mapper;

import io.com.movie.dto.request.MovieRequest;
import io.com.movie.dto.response.MovieResponse;
import io.com.movie.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    @Mapping(target = "movieId", ignore = true)
    Movie toEntity(MovieRequest requestDTO);

    MovieResponse toResponseDTO(Movie entity);
}
