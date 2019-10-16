package es.upm.miw.apaw_ep_fernanda_guerra.order_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.exceptions.BadRequestException;

public class OrderCreationDto {

    private String id;

    private Double price;

    private String operatorId;

    private String croquetaId;

    public OrderCreationDto() {
    }

    public OrderCreationDto(Double price, String operatorId, String croquetaId) {
        this.price = price;
        this.operatorId = operatorId;
        this.croquetaId = croquetaId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getCroquetaId() {
        return croquetaId;
    }

    public void setCroquetaId(String croquetaId) {
        this.croquetaId = croquetaId;
    }

    public void validate() {
        if (this.price == null || this.operatorId == null || this.operatorId.isEmpty()
                || this.croquetaId == null || this.croquetaId.isEmpty()) {
            throw new BadRequestException("Incomplete OrderCreationDto");
        }
    }

    @Override
    public String toString() {
        return "OrderCreationDto{" +
                "price='" + price + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", croquetaId='" + croquetaId + '\'' +
                '}';
    }

}
