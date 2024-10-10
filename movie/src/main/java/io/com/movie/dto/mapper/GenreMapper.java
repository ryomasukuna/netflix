package io.com.movie.dto.mapper;

import io.com.movie.dto.request.GenreRequest;
import io.com.movie.dto.response.GenreResponse;
import io.com.movie.model.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    @Mapping(target = "genreId", ignore = true)
    Genre toEntity(GenreRequest requestDTO);

    GenreResponse toResponseDTO(Genre entity);
}
