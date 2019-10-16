package es.upm.miw.apaw_ep_fernanda_guerra.order_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.ApiTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.Assert.assertEquals;

@ApiTestConfig
class OrderResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        OrderBasicDto orderBasicDto = createOrder(05.00);
        assertEquals(java.util.Optional.of(05.00), orderBasicDto.getPrice());
    }

    OrderBasicDto createOrder(Double price) {
        OrderCreationDto orderCreationDto =
                new OrderCreationDto(06.00, null, null);
        return this.webTestClient
                .post().uri(OrderResource.ORDERS)
                .body(BodyInserters.fromObject(orderCreationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(OrderBasicDto.class)
                .returnResult().getResponseBody();
    }

    @Test
    void testCreateOrderException() {
        OrderCreationDto orderCreationDto =
                new OrderCreationDto(10.00, "5da7464e76f97c20c07a55a4", null);
        this.webTestClient
                .post().uri(OrderResource.ORDERS)
                .body(BodyInserters.fromObject(orderCreationDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testReadOrderPrice() {
        String id = createOrder(20.00).getId();
        OrderBasicDto orderBasicDto = this.webTestClient
                .get().uri(OrderResource.ORDERS + OrderResource.ID_ID + OrderResource.PRICE, id)
                .exchange()
                .expectStatus().isOk()
                .expectBody(OrderBasicDto.class)
                .returnResult().getResponseBody();
        assertEquals(id, orderBasicDto.getId());
        assertEquals(java.util.Optional.of(20.00), orderBasicDto.getPrice());
    }

    @Test
    void testReadOrderPriceException() {
        this.webTestClient
                .get().uri(OrderResource.ORDERS + OrderResource.ID_ID + OrderResource.PRICE, "no")
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }

}
