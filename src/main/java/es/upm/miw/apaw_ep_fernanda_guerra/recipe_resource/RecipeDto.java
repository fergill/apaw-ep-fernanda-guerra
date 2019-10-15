package es.upm.miw.apaw_ep_fernanda_guerra.recipe_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.exceptions.BadRequestException;

public class RecipeDto {

    private String id;

    private String description;

    private String level;

    private Boolean light;

    private Integer guests;

    public RecipeDto() {
    }

    public RecipeDto(String description, String level, Boolean light, Integer guests) {
        this.description = description;
        this.level = level;
        this.light = light;
        this.guests = guests;
    }

    public RecipeDto(Recipe recipe) {
        this.id = recipe.getId();
        this.description = recipe.getDescription();
        this.level = recipe.getLevel();
        this.light = recipe.getLight();
        this.guests = recipe.getGuests();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Boolean getLight() {
        return light;
    }

    public void setLight(Boolean light) {
        this.light = light;
    }

    public Integer getGuests() {
        return guests;
    }

    public void setGuests(Integer guests) {
        this.guests = guests;
    }

    public void validate() {
        if (description == null || description.isEmpty()) {
            throw new BadRequestException("Incomplete RecipeDto. ");
        }
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
