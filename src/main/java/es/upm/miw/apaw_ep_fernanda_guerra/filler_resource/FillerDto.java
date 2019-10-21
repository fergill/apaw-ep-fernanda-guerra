package es.upm.miw.apaw_ep_fernanda_guerra.filler_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.exceptions.BadRequestException;

public class FillerDto {

    private String id;

    private String type;

    private Double percentage;

    private Double price;

    private Boolean gluten;

    private Boolean light;

    private Boolean spicy;

    public FillerDto() {
    }


    public FillerDto(String type, Double percentage, Double price, Boolean gluten, Boolean light, Boolean spicy) {
        this.type = type;
        this.percentage = percentage;
        this.price = price;
        this.gluten = gluten;
        this.light = light;
        this.spicy = spicy;
    }

    public FillerDto(Filler filler) {
        this.id = filler.getId();
        this.type = filler.getType();
        this.percentage = filler.getPercentage();
        this.price = filler.getPrice();
        this.gluten = filler.getGluten();
        this.light = filler.getLight();
        this.spicy = filler.getSpicy();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        if (type == null || type.isEmpty() && price == null || price.isNaN()) {
            throw new BadRequestException("Incomplete FillerDto. ");
        }
    }

    @Override
    public String toString() {
        return "Filler{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", percentage=" + percentage +
                ", price=" + price + '\'' +
                ", gluten=" + gluten + '\'' +
                ", light=" + light + '\'' +
                ", spicy=" + spicy + '\'' +
                '}';
    }


}
