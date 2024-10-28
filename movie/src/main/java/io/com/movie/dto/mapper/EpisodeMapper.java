package io.com.movie.dto.mapper;

import io.com.movie.dto.request.EpisodeRequest;
import io.com.movie.dto.response.EpisodeResponse;
import io.com.movie.model.Episode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EpisodeMapper {
    EpisodeMapper INSTANCE = Mappers.getMapper(EpisodeMapper.class);

    Episode toEntity(EpisodeRequest requestDTO);
    EpisodeResponse toResponseDTO(Episode entity);
}
