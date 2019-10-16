package es.upm.miw.apaw_ep_fernanda_guerra.croqueta_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.ApiTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@ApiTestConfig
public class CroquetaResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        CroquetaBasicDto operatorDto = this.webTestClient
                .post().uri(OperatorResource.OPERATORS)
                .body(BodyInserters.fromObject(new OperatorDto("Carlos", "García", null)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(OperatorDto.class).returnResult().getResponseBody();
        assertNotNull(operatorDto);
        assertEquals("Carlos", operatorDto.getName());
        assertEquals("García", operatorDto.getSurname());
    }
    }
}
