package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.dto.AddOfferDto;
import bg.softuni.mobilele.model.entity.ModelEntity;
import bg.softuni.mobilele.model.entity.OfferEntity;
import bg.softuni.mobilele.model.entity.UserEntity;
import bg.softuni.mobilele.model.mapper.OfferMapper;
import bg.softuni.mobilele.repository.OfferRepository;
import bg.softuni.mobilele.service.ModelService;
import bg.softuni.mobilele.service.OfferService;
import bg.softuni.mobilele.service.UserService;
import bg.softuni.mobilele.user.CurrentUser;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private ModelService modelService;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final OfferMapper offerMapper;


    public OfferServiceImpl(OfferRepository offerRepository,
                            CurrentUser currentUser,
                            UserService userService,
                            OfferMapper offerMapper) {
        this.offerRepository = offerRepository;
        this.currentUser = currentUser;
        this.userService = userService;
        this.offerMapper = offerMapper;
    }


    @Override
    public void add(AddOfferDto offerModel) {
        OfferEntity offerEntity = this.offerMapper.addOfferDtoToOfferEntity(offerModel);
        UserEntity user = this.userService.getByEmail(this.currentUser.getEmail())
                .orElseThrow();
        ModelEntity model = this.modelService.getById(offerModel.getModelId())
                .orElseThrow();

        offerEntity.setSeller(user);
        offerEntity.setModel(model);

        this.offerRepository.save(offerEntity);
    }
}
