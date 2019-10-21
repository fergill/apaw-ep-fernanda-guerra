package es.upm.miw.apaw_ep_fernanda_guerra.filler_resource;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Filler {

    @Id
    private String id;

    private String type;

    private Double percentage;

    private Double price;

    private Boolean gluten;

    private Boolean light;

    private Boolean spicy;

    public Filler() {
        this.id = id;
        this.type = type;
        this.percentage = percentage;
        this.price = price;
        this.gluten = gluten;
        this.light = light;
        this.spicy = spicy;
    }

    public String getId() {
        return this.id;
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
}
