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

    public String getId() {
        return this.id;
    }

    public String getType() {
        return type;
    }

    public Double getPercentage() {
        return percentage;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getGluten() {
        return gluten;
    }

    public Boolean getLight() {
        return light;
    }

    public Boolean getSpicy() {
        return spicy;
    }

}
