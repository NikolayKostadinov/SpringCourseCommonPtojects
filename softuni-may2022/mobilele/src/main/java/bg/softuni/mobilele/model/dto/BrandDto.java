package bg.softuni.mobilele.model.dto;

import java.util.ArrayList;
import java.util.List;

public class BrandDto {

    private String name;
    private List<ModelDto> models;

    public BrandDto() {
        this.models = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public BrandDto setName(String name) {
        this.name = name;
        return this;
    }

    public List<ModelDto> getModels() {
        return models;
    }

    public BrandDto setModels(List<ModelDto> models) {
        this.models = models;
        return this;
    }

    public BrandDto аddModel(ModelDto model) {
        this.models.add(model);
        return this;
    }
}
