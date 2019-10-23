package es.upm.miw.apaw_ep_fernanda_guerra.filler_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.ApiTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.stream.Collectors;

@ApiTestConfig
public class FillerResourceIT {

    @Autowired
    private WebTestClient webTestClient;


    @Test
    void deleteFiller() {
        String fillerId = this.webTestClient
                .post().uri(FillerResource.FILLERS)
                .body(BodyInserters.fromObject(new FillerDto("Chorizo", 50.00, 03.00, false, false, false)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(FillerDto.class).returnResult().getResponseBody().getId();
        this.webTestClient
                .delete().uri(FillerResource.FILLERS + FillerResource.ID_ID, fillerId)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void deleteFillerException() {
        this.webTestClient
                .delete().uri(FillerResource.FILLERS + FillerResource.ID_ID, "")
                .exchange()
                .expectStatus()
                .isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testSearch() {
        this.webTestClient
                .post().uri(FillerResource.FILLERS)
                .body(BodyInserters.fromObject(new FillerDto("Chorizo", 50.00, 03.00, false, true, true)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(FillerDto.class).returnResult().getResponseBody();
        this.webTestClient
                .post().uri(FillerResource.FILLERS)
                .body(BodyInserters.fromObject(new FillerDto("Bacon", 50.00, 03.00, false, true, true)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(FillerDto.class).returnResult().getResponseBody();
        this.webTestClient
                .post().uri(FillerResource.FILLERS)
                .body(BodyInserters.fromObject(new FillerDto("Jamón", 50.00, 03.00, false, false, true)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(FillerDto.class).returnResult().getResponseBody();
        this.webTestClient
                .get().uri(uriBuilder ->
                uriBuilder.path(FillerResource.FILLERS + FillerResource.SEARCH)
                        .queryParam("q", ("light"+"spicy"))
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(FillerDto.class)
                .returnResult().getResponseBody().stream().collect(Collectors.toList());

    }

}


