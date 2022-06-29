package bg.softuni.mobilele.model.dto;

import bg.softuni.mobilele.model.enums.EngineEnum;
import bg.softuni.mobilele.model.enums.TransmissionEnum;

import javax.validation.constraints.*;

public class AddOfferDto {
    @NotNull(message = "Engine selection is required!")
    private EngineEnum engine;

    @NotNull(message = "Transmission selection is required!")
    private TransmissionEnum transmission;

    @NotNull(message = "Model selection is required!")
    private Long modelId;

    @NotNull(message = "Price is required!")
    @Positive(message = "Price must be positive!")
    private Integer price;

    @NotNull(message = "Year is required")
    @Min(value = 1900, message = "Year must be greater than {value}")
    private Integer year;

    @NotNull(message = "Millage is required")
    @Min(value = 0, message = "Mileage must be greater than {value}")
    @Max(value=900000,  message = "Mileage must be lower than {value}")
    private Integer mileage;
    @NotEmpty
    private String description;

    @NotEmpty
    private String imageUrl;

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

    public Long getModelId() {
        return modelId;
    }

    public AddOfferDto setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public AddOfferDto setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public AddOfferDto setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public AddOfferDto setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddOfferDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AddOfferDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
