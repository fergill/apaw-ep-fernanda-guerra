package es.upm.miw.apaw_ep_fernanda_guerra.recipe_resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class RecipeBusinessController {

    private RecipeDao recipeDao;

    @Autowired
    public RecipeBusinessController(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    public RecipeDto create(RecipeDto recipeDto) {
        Recipe recipe = new Recipe(
                recipeDto.getDescription(),
                recipeDto.getLevel(),
                recipeDto.getLight(),
                recipeDto.getGuests());
        this.recipeDao.save(recipe);
        return new RecipeDto(recipe);
    }

    public List<RecipeDto> readAll() {
        List<Recipe> recipes = this.recipeDao.findAll();
        return recipes.stream().map(RecipeDto::new).collect(Collectors.toList());
    }

}