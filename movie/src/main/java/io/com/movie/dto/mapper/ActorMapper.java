package io.com.movie.dto.mapper;

import io.com.movie.dto.request.ActorRequest;
import io.com.movie.dto.request.SeasonRequest;
import io.com.movie.dto.response.ActorResponse;
import io.com.movie.dto.response.SeasonResponse;
import io.com.movie.model.Actor;
import io.com.movie.model.Season;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ActorMapper {
    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);

    Actor toEntity(ActorRequest requestDTO);
    ActorResponse toResponseDTO(Actor entity);
}
