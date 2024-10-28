package io.com.movie.dto.mapper;

import io.com.movie.dto.request.SeriesRequest;
import io.com.movie.dto.response.SeriesResponse;
import io.com.movie.model.Series;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SeriesMapper {
    SeriesMapper INSTANCE = Mappers.getMapper(SeriesMapper.class);

    Series toEntity(SeriesRequest requestDTO);
    SeriesResponse toResponseDTO(Series entity);
}
