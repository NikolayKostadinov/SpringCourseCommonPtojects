package bg.softuni.mobilele.model.mapper;

import bg.softuni.mobilele.model.dto.AddOfferDto;
import bg.softuni.mobilele.model.entity.OfferEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OfferMapper {

    OfferEntity addOfferDtoToOfferEntity(AddOfferDto offerModel);
}
