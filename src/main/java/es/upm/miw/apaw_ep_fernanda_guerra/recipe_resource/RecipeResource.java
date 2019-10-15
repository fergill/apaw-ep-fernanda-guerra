package es.upm.miw.apaw_ep_fernanda_guerra.recipe_resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RecipeResource.RECIPES)
public class RecipeResource {

    static final String RECIPES = "/recipes";

    private RecipeBusinessController recipeBusinessController;

    @Autowired
    public RecipeResource(RecipeBusinessController recipeBusinessController) {
        this.recipeBusinessController = recipeBusinessController;
    }

    @PostMapping
    public RecipeDto create(@RequestBody RecipeDto recipeDto) {
        recipeDto.validate();
        return this.recipeBusinessController.create(recipeDto);
    }

    @GetMapping
    public List<RecipeDto> readAll() {
        return this.recipeBusinessController.readAll();
    }

}
