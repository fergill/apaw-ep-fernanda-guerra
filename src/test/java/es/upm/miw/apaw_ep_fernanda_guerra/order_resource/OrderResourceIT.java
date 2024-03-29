package es.upm.miw.apaw_ep_fernanda_guerra.order_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.ApiTestConfig;
import es.upm.miw.apaw_ep_fernanda_guerra.croqueta_resource.CroquetaDto;
import es.upm.miw.apaw_ep_fernanda_guerra.croqueta_resource.CroquetaResource;
import es.upm.miw.apaw_ep_fernanda_guerra.operator_resource.OperatorDto;
import es.upm.miw.apaw_ep_fernanda_guerra.operator_resource.OperatorResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ApiTestConfig
public class OrderResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    String createOrder() {
        OperatorDto operatorDto =
                new OperatorDto("Fernanda", "Guerra", "909090X");
        String operatorId = this.webTestClient
                .post().uri(OperatorResource.OPERATORS)
                .body(BodyInserters.fromObject(operatorDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(OperatorDto.class)
                .returnResult().getResponseBody().getId();
        CroquetaDto croquetaBasicDto =
                new CroquetaDto();
        String croquetaId = this.webTestClient
                .post().uri(CroquetaResource.CROQUETAS)
                .body(BodyInserters.fromObject(croquetaBasicDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(CroquetaDto.class)
                .returnResult().getResponseBody().getId();
        return this.webTestClient
                .post().uri(OrderResource.ORDERS)
                .body(BodyInserters.fromObject(new OrderCreationDto(90.00, operatorId, croquetaId)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(OrderBasicDto.class)
                .returnResult().getResponseBody().getId();
    }

    @Test
    void testCreate() {
        this.createOrder();
    }

    @Test
    void testReadOperator() {
        String orderId = this.createOrder();
        String operatorId = this.webTestClient
                .get().uri(OrderResource.ORDERS + OrderResource.ID_ID + OrderResource.OPERATOR, orderId)
                .exchange()
                .expectBody(OperatorDto.class)
                .returnResult().getResponseBody().getId();
        assertNotNull(operatorId);
    }

    @Test
    void testPutTotal() {
        String id = this.createOrder();
        OrderBasicDto newOrder = new OrderBasicDto();
        newOrder.setTotal(10.00);
        this.webTestClient
                .put().uri(OrderResource.ORDERS + OrderResource.ID_ID + OrderResource.TOTAL, id)
                .body(BodyInserters.fromObject(newOrder))
                .exchange()
                .expectStatus().isOk();
        newOrder = this.webTestClient
                .get().uri(OrderResource.ORDERS + OrderResource.ID_ID + OrderResource.TOTAL, id)
                .exchange()
                .expectStatus().isOk()
                .expectBody(OrderBasicDto.class)
                .returnResult().getResponseBody();
        assertEquals(10.00, newOrder.getTotal(), 0.001);
    }

    @Test
    void testPutTotalNotFoundException() {
        String id = this.createOrder();
        OrderBasicDto newOrder = new OrderBasicDto();
        this.webTestClient
                .put().uri(OrderResource.ORDERS + OrderResource.ID_ID + OrderResource.TOTAL, id)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testPutTotalBadRequestException() {
        this.webTestClient
                .put().uri(OrderResource.ORDERS + OrderResource.ID_ID + OrderResource.TOTAL, "123")
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

}