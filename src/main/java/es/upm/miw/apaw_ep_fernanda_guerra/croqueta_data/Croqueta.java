package es.upm.miw.apaw_ep_fernanda_guerra.croqueta_data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Croqueta {

    @Id
    private String id;

    @DBRef
    private List<Filler> fillers;

    public Croqueta() {
        this.fillers = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<Filler> getFillers() {
        return fillers;
    }

}