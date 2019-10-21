package es.upm.miw.apaw_ep_fernanda_guerra.order_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.exceptions.BadRequestException;

public class OrderBasicDto {

    private String id;

    private Double total;

    public OrderBasicDto() {
    }

    public OrderBasicDto(Order order) {
        this.id = order.getId();
        this.total = order.getTotal();
    }

    public OrderBasicDto(String id, Double total) {
        this.id = id;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void validate() {
        if (total == null || total.isNaN()) {
            throw new BadRequestException("Incomplete, lost total");
        }

    }

    @Override
    public String toString() {
        return "OrderBasicDto{" +
                "id='" + id + '\'' +
                ", total='" + total + '\'' +
                '}';
    }

}