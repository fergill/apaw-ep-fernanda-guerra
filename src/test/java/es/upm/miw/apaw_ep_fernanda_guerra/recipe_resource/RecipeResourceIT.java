package es.upm.miw.apaw_ep_fernanda_guerra.recipe_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.ApiTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ApiTestConfig
class RecipeResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        RecipeDto recipeDto = this.webTestClient
                .post().uri(RecipeResource.RECIPES)
                .body(BodyInserters.fromObject(new RecipeDto("Pastel de Chocolate", null, false, null)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(RecipeDto.class).returnResult().getResponseBody();
        assertNotNull(recipeDto);
        assertFalse(recipeDto.getLight());
        assertEquals("Pastel de Chocolate", recipeDto.getDescription());
    }

    @Test
    void testCreateRecipeException() {
        RecipeDto recipeDto = new RecipeDto(null, null, false, null);
        this.webTestClient
                .post().uri(RecipeResource.RECIPES)
                .body(BodyInserters.fromObject(recipeDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void ReadAll() {
        RecipeDto recipeDto = new RecipeDto("Tarta de queso", null, false, null);
        this.webTestClient
                .post().uri(RecipeResource.RECIPES)
                .body(BodyInserters.fromObject(recipeDto))
                .exchange()
                .expectStatus().isOk();
        List<RecipeDto> list =
                this.webTestClient
                        .get().uri(RecipeResource.RECIPES)
                        .exchange()
                .expectStatus().isOk()
                .expectBodyList(RecipeDto.class)
                .returnResult().getResponseBody();
        assertTrue(list.size() > 0);
        assertNotNull(list.get(0).getId());
        assertNotNull(list.get(0).getDescription());
    }

}