package es.upm.miw.apaw_ep_fernanda_guerra.recipe_resource;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Recipe {

    @Id
    private String id;

    private String description;

    private String level;

    private Boolean light;

    private Integer guests;

    public Recipe(String id, String description, String level, Boolean light, Integer guests) {
        this.id = id;
        this.description = description;
        this.level = level;
        this.light = light;
        this.guests = guests;
    }

    public String getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public String getLevel() {
        return this.level;
    }

    public Boolean getLight() {
        return this.light;
    }

    public Integer getGuests() {
        return this.guests;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id='" + id + '\'' +
                ", description=" + description +
                ", level=" + level +
                ", light=" + light +
                ", guests=" + guests + '\'' +
                '}';
    }

}
