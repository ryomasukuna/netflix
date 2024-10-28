package io.com.movie.dto.mapper;
import io.com.movie.dto.request.PosterRequest;
import io.com.movie.dto.response.PosterResponse;
import io.com.movie.model.Poster;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PosterMapper {
    PosterMapper INSTANCE = Mappers.getMapper(PosterMapper.class);

    Poster toEntity(PosterRequest requestDTO);
    PosterResponse toResponseDTO(Poster entity);

}
