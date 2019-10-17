package es.upm.miw.apaw_ep_fernanda_guerra.croqueta_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.croqueta_data.Croqueta;
import es.upm.miw.apaw_ep_fernanda_guerra.croqueta_data.Filler;

public class CroquetaBasicDto {

    private String type;
    private Double price;

    public CroquetaBasicDto() {
    }

    public CroquetaBasicDto(Filler filler) {
        this.type = filler.getType();
        this.price = filler.getPrice();
    }

    public String getType() {
        return type;
    }

    public void setId(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CroquetaBasicDto{" +
                "type='" + type + '\'' +
                "price='" + price + '\'' +
                '}';
    }

}
