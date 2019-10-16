package es.upm.miw.apaw_ep_fernanda_guerra.operator_data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Operator {

    @Id
    private String id;

    private String name;

    private String surname;

    private String dni;

    public Operator(String name, String surname, String dni) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDni() {
        return dni;
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
