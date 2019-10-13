package es.upm.miw.apaw_ep_fernanda_guerra;

public class Responsible {

    private String id;

    private String name;

    private String surname;

    private String dni;

    public Responsible(String id, String name, String surname, String dni) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getDni() {
        return this.dni;
    }

}
