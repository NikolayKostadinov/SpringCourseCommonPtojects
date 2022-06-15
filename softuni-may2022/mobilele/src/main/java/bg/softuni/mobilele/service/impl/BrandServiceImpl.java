package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.dto.BrandDto;
import bg.softuni.mobilele.model.mapper.BrandMapper;
import bg.softuni.mobilele.repository.BrandRepository;
import bg.softuni.mobilele.repository.OfferRepository;
import bg.softuni.mobilele.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public BrandServiceImpl(BrandRepository brandRepository,
                            BrandMapper brandMapper) {

        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }

    @Override
    public List<BrandDto> getAllBrands() {
        return this.brandMapper.map(this.brandRepository.findAll());
    }
}
