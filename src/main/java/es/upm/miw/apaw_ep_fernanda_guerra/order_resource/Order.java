package es.upm.miw.apaw_ep_fernanda_guerra.order_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.croqueta_data.Croqueta;
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

    private Double price;

    @DBRef
    private Operator operator;

    private Croqueta croqueta;

    public Order(Double price, Operator operator, Croqueta croqueta) {
        this.date = LocalDateTime.now();
        this.price = price;
        this.operator = operator;
        this.croqueta = croqueta;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Double getPrice() {
        return price;
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
                ", price=" + price +
                ", operator=" + operator + '\'' +
                ", croqueta=" + croqueta + '\'' +
                '}';
    }

}