package es.upm.miw.apaw_ep_fernanda_guerra;

public class Filler {

    private String id;

    private String type;

    private Float percentage;

    private Float price;

    private Boolean gluten;

    private Boolean light;

    private Boolean spicy;

    public Filler(String id, String type, Float percentage, Float price, Boolean gluten, Boolean light, Boolean spicy) {
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
        return this.type;
    }

    public Float getPercentage() {
        return this.percentage;
    }

    public Float getPrice() {
        return this.price;
    }

    public Boolean getGluten() {
        return this.gluten;
    }

    public Boolean getLight() {
        return this.light;
    }

    public Boolean getSpicy() {
        return this.spicy;
    }

}
