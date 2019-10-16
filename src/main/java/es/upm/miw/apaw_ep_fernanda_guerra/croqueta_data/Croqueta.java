package es.upm.miw.apaw_ep_fernanda_guerra.croqueta_data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Croqueta {

    @Id
    private String id;

    @DBRef
    private Filler filler;

    public Croqueta(Filler filler) {
        this.filler = filler;
    }

    public String getId() {
        return id;
    }

    public Filler getFiller() {
        return filler;
    }

    @Override
    public String toString() {
        return "Croqueta{" +
                "id='" + id + '\'' +
                ", filler=" + filler + '\'' +
                '}';
    }

}
