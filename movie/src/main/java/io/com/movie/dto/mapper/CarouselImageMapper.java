package io.com.movie.dto.mapper;

import io.com.movie.dto.request.CarouselImageRequest;
import io.com.movie.dto.response.CarouselImageResponse;
import io.com.movie.model.CarouselImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CarouselImageMapper {

    CarouselImageMapper INSTANCE = Mappers.getMapper(CarouselImageMapper.class);

    @Mapping(target = "carouselImageId", ignore = true)  // Ignore auto-generated ID
    CarouselImage toEntity(CarouselImageRequest requestDTO);

    CarouselImageResponse toResponseDTO(CarouselImage entity);

}
