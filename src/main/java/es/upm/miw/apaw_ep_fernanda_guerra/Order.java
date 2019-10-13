package es.upm.miw.apaw_ep_fernanda_guerra;

import java.time.LocalDateTime;

public class Order {

    private String id;

    private LocalDateTime date;

    private Float total;

    public Order(String id, LocalDateTime date, Float total) {
        this.id = id;
        this.date = date;
        this.total = total;
    }

    public String getId() {
        return this.id;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public Float getTotal() {
        return this.total;
    }

}
