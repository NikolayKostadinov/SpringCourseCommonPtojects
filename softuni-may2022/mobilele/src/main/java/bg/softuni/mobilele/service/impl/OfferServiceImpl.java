package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.dto.AddOfferDto;
import bg.softuni.mobilele.model.entity.ModelEntity;
import bg.softuni.mobilele.model.entity.OfferEntity;
import bg.softuni.mobilele.model.mapper.OfferMapper;
import bg.softuni.mobilele.repository.OfferRepository;
import bg.softuni.mobilele.service.ModelService;
import bg.softuni.mobilele.service.OfferService;
import bg.softuni.mobilele.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelService modelService;
    private final UserService userService;
    private final OfferMapper offerMapper;


    public OfferServiceImpl(OfferRepository offerRepository,
                            ModelService modelService,
                            UserService userService,
                            OfferMapper offerMapper) {
        this.offerRepository = offerRepository;
        this.modelService = modelService;
        this.userService = userService;
        this.offerMapper = offerMapper;
    }


    @Override
    public void add(AddOfferDto offerModel) {
        OfferEntity offerEntity = this.offerMapper.addOfferDtoToOfferEntity(offerModel);
        // todo
//        UserEntity user = this.userService.getByEmail(this.currentUser.getEmail())
//                .orElseThrow();
        ModelEntity model = this.modelService.getById(offerModel.getModelId())
                .orElseThrow();

//        todo
//        offerEntity.setSeller(user);
        offerEntity.setModel(model);
        this.offerRepository.save(offerEntity);
    }
}
