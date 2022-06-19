package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.entity.ModelEntity;
import bg.softuni.mobilele.repository.ModelRepository;
import bg.softuni.mobilele.service.ModelService;

import java.util.Optional;

public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public Optional<ModelEntity> getById(Long modelId) {
        return this.modelRepository.findById(modelId);
    }
}
