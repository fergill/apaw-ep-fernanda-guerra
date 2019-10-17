package es.upm.miw.apaw_ep_fernanda_guerra.operator_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.ApiTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.List;

import static org.junit.Assert.*;

@ApiTestConfig
class OperatorResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        OperatorDto operatorDto = this.webTestClient
                .post().uri(OperatorResource.OPERATORS)
                .body(BodyInserters.fromObject(new OperatorDto("Carlos", "García", null)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(OperatorDto.class).returnResult().getResponseBody();
        assertNotNull(operatorDto);
        assertEquals("Carlos", operatorDto.getName());
        assertEquals("García", operatorDto.getSurname());
    }

    @Test
    void testCreateOperatorException() {
        OperatorDto operatorDto = new OperatorDto(null, null, null);
        this.webTestClient
                .post().uri(OperatorResource.OPERATORS)
                .body(BodyInserters.fromObject(operatorDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void readAll() {
        OperatorDto operatorDto = new OperatorDto("Luis", "Guerra", "27057959T");
        this.webTestClient
                .post().uri(OperatorResource.OPERATORS)
                .body(BodyInserters.fromObject(operatorDto))
                .exchange()
                .expectStatus().isOk();
        List<OperatorDto> list =
                this.webTestClient
                        .get().uri(OperatorResource.OPERATORS)
                        .exchange()
                        .expectStatus().isOk()
                        .expectBodyList(OperatorDto.class)
                        .returnResult().getResponseBody();
        assert list != null;
        assertTrue(list.size() > 0);
        assertNotNull(list.get(0).getId());
        assertNotNull(list.get(0).getName());
        assertNotNull(list.get(0).getSurname());
    }

}