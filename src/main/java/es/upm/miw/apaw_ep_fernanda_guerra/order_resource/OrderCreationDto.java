package es.upm.miw.apaw_ep_fernanda_guerra.order_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.exceptions.BadRequestException;

public class OrderCreationDto {

    private String id;

    private Double total;

    private String operatorId;

    private String croquetaId;

    public OrderCreationDto() {
    }

    public OrderCreationDto(Double total, String operatorId, String croquetaId) {
        this.total = total;
        this.operatorId = operatorId;
        this.croquetaId = croquetaId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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
        if (total == null || total.isNaN() || this.operatorId == null || this.operatorId.isEmpty()
                || this.croquetaId == null || this.croquetaId.isEmpty()) {
            throw new BadRequestException("Incomplete OrderCreationDto");
        }
    }

    @Override
    public String toString() {
        return "OrderCreationDto{" +
                "total='" + total + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", croquetaId='" + croquetaId + '\'' +
                '}';
    }

}
