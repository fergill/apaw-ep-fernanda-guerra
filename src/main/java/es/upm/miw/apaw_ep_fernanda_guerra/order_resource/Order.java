package es.upm.miw.apaw_ep_fernanda_guerra.order_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.croqueta_resource.Croqueta;
import es.upm.miw.apaw_ep_fernanda_guerra.operator_data.Operator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Order {

    @Id
    private String id;

    private LocalDateTime date;

    private Double total;

    @DBRef
    private Operator operator;

    private Croqueta croqueta;

    public Order(Double total, Operator operator, Croqueta croqueta) {
        this.date = LocalDateTime.now();
        this.total = total;
        this.operator = operator;
        this.croqueta = croqueta;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Operator getOperator() {
        return operator;
    }

    public Croqueta getCroqueta() {
        return croqueta;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", total=" + total +
                ", operator=" + operator + '\'' +
                ", croqueta=" + croqueta + '\'' +
                '}';
    }


}