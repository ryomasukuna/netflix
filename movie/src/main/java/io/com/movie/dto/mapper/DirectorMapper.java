package io.com.movie.dto.mapper;

import io.com.movie.dto.request.DirectorRequest;
import io.com.movie.dto.response.DirectorResponse;
import io.com.movie.model.Director;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DirectorMapper {
    DirectorMapper INSTANCE = Mappers.getMapper(DirectorMapper.class);

    Director toEntity(DirectorRequest requestDTO);
    DirectorResponse toResponseDTO(Director entity);
}
