package es.upm.miw.apaw_ep_fernanda_guerra.order_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.exceptions.BadRequestException;

public class OrderBasicDto {

    private String id;

    private Double price;

    public OrderBasicDto() {
    }

    public OrderBasicDto(Order order) {
        this.id = order.getId();
        this.price = order.getPrice();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void validatePrice() {
        if (this.price == null) {
            throw new BadRequestException("Incomplete, lost price");
        }
    }

    @Override
    public String toString() {
        return "OrderBasicDto{" +
                "id='" + id + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

}