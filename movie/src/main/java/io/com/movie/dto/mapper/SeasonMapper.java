package io.com.movie.dto.mapper;
import io.com.movie.dto.request.SeasonRequest;
import io.com.movie.dto.response.SeasonResponse;
import io.com.movie.model.Season;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SeasonMapper {
    SeasonMapper INSTANCE = Mappers.getMapper(SeasonMapper.class);

    @Mapping(target = "seasonId", ignore = true)
    Season toEntity(SeasonRequest requestDTO);

    SeasonResponse toResponseDTO(Season entity);
}
