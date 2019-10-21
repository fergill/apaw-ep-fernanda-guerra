package es.upm.miw.apaw_ep_fernanda_guerra.croqueta_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.exceptions.BadRequestException;
import es.upm.miw.apaw_ep_fernanda_guerra.filler_resource.Filler;

public class CroquetaDto {

    private String id;

    private String frozen;

    private Filler filler;

    public CroquetaDto() {
    }

    public CroquetaDto(String id, String frozen) {
        this.id = id;
        this.frozen = frozen;
    }

    public CroquetaDto(Croqueta croqueta) {
        this.id = croqueta.getId();
        this.frozen = croqueta.getFrozen();
        this.filler = croqueta.getFiller();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrozen() {
        return frozen;
    }

    public void setFrozen(String frozen) {
        this.frozen = frozen;
    }

    public Filler getFiller() {
        return filler;
    }

    public void setFiller(Filler filler) {
        this.filler = filler;
    }

    public void validate() {
        if (frozen == null || frozen.isEmpty()) {
            throw new BadRequestException("Incomplete CroquetaDto. ");
        }
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