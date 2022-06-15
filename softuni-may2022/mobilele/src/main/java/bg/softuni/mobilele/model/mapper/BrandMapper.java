package bg.softuni.mobilele.model.mapper;

import bg.softuni.mobilele.model.dto.BrandDto;
import bg.softuni.mobilele.model.dto.ModelDto;
import bg.softuni.mobilele.model.entity.BrandEntity;
import bg.softuni.mobilele.model.entity.ModelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    BrandDto toBrandDto(BrandEntity brand);

    List<BrandDto> map(List<BrandEntity> brands);

    ModelDto toModelDto(ModelEntity model);

}
