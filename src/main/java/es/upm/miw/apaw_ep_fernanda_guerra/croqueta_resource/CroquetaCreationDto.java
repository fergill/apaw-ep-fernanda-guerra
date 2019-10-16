package es.upm.miw.apaw_ep_fernanda_guerra.croqueta_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.exceptions.BadRequestException;

public class CroquetaCreationDto {

    private String type;

    private Double percentage;

    private Double price;

    private Boolean gluten;

    private Boolean light;

    private Boolean spicy;

    public CroquetaCreationDto() {
    }

    public CroquetaCreationDto(String type, Double percentage, Double price, Boolean gluten, Boolean light, Boolean spicy) {
        this.type = type;
        this.percentage = percentage;
        this.price = price;
        this.gluten = gluten;
        this.light = light;
        this.spicy = spicy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getGluten() {
        return gluten;
    }

    public void setGluten(Boolean gluten) {
        this.gluten = gluten;
    }

    public Boolean getLight() {
        return light;
    }

    public void setLight(Boolean light) {
        this.light = light;
    }

    public Boolean getSpicy() {
        return spicy;
    }

    public void setSpicy(Boolean spicy) {
        this.spicy = spicy;
    }

    public void validate() {
        if (this.price == null || this.type == null || this.type.isEmpty() || this.percentage == null) {
            throw new BadRequestException("Incomplete CroquetaCreationDto");
        }
    }

    @Override
    public String toString() {
        return "CroquetaCreationDto{" +
                "type='" + type + '\'' +
                ", percentage='" + percentage + '\'' +
                ", price='" + price + '\'' +
                ", gluten='" + gluten + '\'' +
                ", light='" + light + '\'' +
                ", spicy='" + spicy + '\'' +
                '}';
    }
}