package es.upm.miw.apaw_ep_fernanda_guerra.operator_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.exceptions.BadRequestException;

public class OperatorDto {

    private String id;

    private String name;

    private String surname;

    private String dni;

    public OperatorDto() {
    }

    public OperatorDto(String name, String surname, String dni) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
    }

    public OperatorDto(Operator operator) {
        this.id = operator.getId();
        this.name = operator.getName();
        this.surname = operator.getSurname();
        this.dni = operator.getDni();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void validate() {
        if (name == null || name.isEmpty() && surname == null || surname.isEmpty()) {
            throw new BadRequestException("Incomplete OperatorDto. ");
        }
    }

    @Override
    public String toString() {
        return "Operator{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", surname=" + surname +
                ", dni=" + dni + '\'' +
                '}';
    }

}