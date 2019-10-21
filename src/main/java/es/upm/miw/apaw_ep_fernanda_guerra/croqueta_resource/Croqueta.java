package es.upm.miw.apaw_ep_fernanda_guerra.croqueta_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.filler_resource.Filler;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Croqueta {

    @Id
    private String id;

    private String frozen;

    @DBRef
    private Filler filler;

    public Croqueta(String frozen) {
        this.frozen = frozen;
    }

    public String getId() {
        return id;
    }

    public String getFrozen() {
        return frozen;
    }

    public Filler getFiller() {
        return filler;
    }

    @Override
    public String toString() {
        return "Croqueta{" +
                "id='" + id + '\'' +
                ", frozen=" + frozen +
                ", filler=" + filler + '\'' +
                '}';
    }
}