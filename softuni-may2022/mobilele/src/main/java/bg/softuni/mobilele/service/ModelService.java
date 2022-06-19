package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.entity.ModelEntity;

import java.util.Optional;

public interface ModelService {
    Optional<ModelEntity> getById(Long modelId);
}
