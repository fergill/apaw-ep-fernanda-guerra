package es.upm.miw.apaw_ep_fernanda_guerra.croqueta_data;

public class Filler {

    private String type;

    private Double percentage;

    private Double price;

    private Boolean gluten;

    private Boolean light;

    private Boolean spicy;

    public Filler(String type, Double percentage, Double price, Boolean gluten, Boolean light, Boolean spicy) {
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
