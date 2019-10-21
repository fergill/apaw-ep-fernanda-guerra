package es.upm.miw.apaw_ep_fernanda_guerra.filler_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.ApiTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

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
    void testPatchFiller() {
        String fillerId = this.webTestClient
                .post().uri(FillerResource.FILLERS)
                .body(BodyInserters.fromObject(new FillerDto("Chorizo", 50.00, 03.00, false, false, false)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(FillerDto.class).returnResult().getResponseBody().getId();
        this.webTestClient
                .patch().uri(FillerResource.FILLERS + FillerResource.ID_ID, fillerId)
                .body(BodyInserters.fromObject(new FillerPatchDto("spicy", "true")))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testPatchFillerIdException() {
        this.webTestClient
                .patch().uri(FillerResource.FILLERS + FillerResource.ID_ID, "no")
                .body(BodyInserters.fromObject(new FillerPatchDto("type", "other")))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void testPatchFillerDtoException() {
        FillerDto fillerDto = new FillerDto("vegetal", 10.00, 01.00, false, true, false);
        String id = fillerDto.getId();
        this.webTestClient
                .patch().uri(FillerResource.FILLERS + FillerResource.ID_ID, id)
                .body(BodyInserters.fromObject(new FillerPatchDto()))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }


}