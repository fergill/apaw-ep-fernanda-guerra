package es.upm.miw.apaw_ep_fernanda_guerra.croqueta_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.ApiTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ApiTestConfig
public class CroquetaResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        CroquetaDto croquetaDto = this.webTestClient
                .post().uri(CroquetaResource.CROQUETAS)
                .body(BodyInserters.fromObject(new CroquetaDto("croquetaId", "Frozen to go")))
                .exchange()
                .expectStatus().isOk()
                .expectBody(CroquetaDto.class).returnResult().getResponseBody();
        assertNotNull(croquetaDto);
        assertEquals("Frozen to go", croquetaDto.getFrozen());
    }

}
