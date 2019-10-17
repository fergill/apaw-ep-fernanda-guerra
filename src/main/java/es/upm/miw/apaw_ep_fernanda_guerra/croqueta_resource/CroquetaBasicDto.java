package es.upm.miw.apaw_ep_fernanda_guerra.croqueta_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.croqueta_data.Croqueta;

public class CroquetaBasicDto {

    private String id;

    public CroquetaBasicDto() {
    }

    public CroquetaBasicDto(Croqueta croqueta) {
        this.id = croqueta.getId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CroquetaBasicDto{" +
                "id='" + id + '\'' +
                '}';
    }
}
