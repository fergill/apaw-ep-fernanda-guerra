package es.upm.miw.apaw_ep_fernanda_guerra.recipe_resource;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeDao extends MongoRepository<Recipe, String> {
}