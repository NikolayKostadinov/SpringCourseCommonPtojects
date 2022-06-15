package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.dto.BrandDto;
import bg.softuni.mobilele.model.mapper.BrandMapper;
import bg.softuni.mobilele.repository.BrandRepository;
import bg.softuni.mobilele.repository.OfferRepository;
import bg.softuni.mobilele.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public OfferServiceImpl(OfferRepository offerRepository,
                            BrandRepository brandRepository, BrandMapper brandMapper) {
        this.offerRepository = offerRepository;
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }

    @Override
    public List<BrandDto> getAllBrands() {
        return this.brandMapper.map(this.brandRepository.findAll());
    }
}
