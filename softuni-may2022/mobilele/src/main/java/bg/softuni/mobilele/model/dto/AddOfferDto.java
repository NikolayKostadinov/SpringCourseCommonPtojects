package bg.softuni.mobilele.model.dto;

import bg.softuni.mobilele.model.enums.EngineEnum;
import bg.softuni.mobilele.model.enums.TransmissionEnum;

import javax.validation.constraints.NotNull;

public class AddOfferDto {
    @NotNull(message = "Engine selection is required!")
    private EngineEnum engine;

    @NotNull(message = "Transmission selection is required!")
    private TransmissionEnum transmission;

    @NotNull(message = "Model selection is required!")
    private Long model;

    public Long getModel() {
        return model;
    }

    public AddOfferDto setModel(Long model) {
        this.model = model;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public AddOfferDto setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public AddOfferDto setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }
}
