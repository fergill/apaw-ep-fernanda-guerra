package es.upm.miw.apaw_ep_fernanda_guerra.order_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.ApiTestConfig;
import es.upm.miw.apaw_ep_fernanda_guerra.croqueta_data.Croqueta;
import es.upm.miw.apaw_ep_fernanda_guerra.croqueta_resource.CroquetaBasicDto;
import es.upm.miw.apaw_ep_fernanda_guerra.croqueta_resource.CroquetaCreationDto;
import es.upm.miw.apaw_ep_fernanda_guerra.croqueta_resource.CroquetaResource;
import es.upm.miw.apaw_ep_fernanda_guerra.operator_data.Operator;
import es.upm.miw.apaw_ep_fernanda_guerra.operator_resource.OperatorDto;
import es.upm.miw.apaw_ep_fernanda_guerra.operator_resource.OperatorResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.*;

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
        CroquetaBasicDto croquetaBasicDto =
                new CroquetaBasicDto();
        String croquetaId = this.webTestClient
                .post().uri(CroquetaResource.CROQUETAS)
                .body(BodyInserters.fromObject(croquetaBasicDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(CroquetaBasicDto.class)
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
        Operator operator = new Operator("Aida", "Gil", "1X");
        Croqueta croqueta = new Croqueta();
        Order order = new Order(30.00, operator, croqueta);
        this.webTestClient
                .get().uri(OrderResource.ORDERS + OrderResource.ID_ID + OrderResource.OPERATOR, order)
                .exchange()
                .expectBody(Order.class)
                .returnResult().getResponseBody().getOperator().getName();
        assertEquals("Aida", order.getOperator().getName());
    }
}
