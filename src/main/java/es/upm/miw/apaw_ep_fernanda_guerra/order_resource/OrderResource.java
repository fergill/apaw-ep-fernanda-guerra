package es.upm.miw.apaw_ep_fernanda_guerra.order_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.operator_resource.OperatorDto;
import io.swagger.v3.oas.models.media.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(OrderResource.ORDERS)
public class OrderResource {

    public static final String ORDERS = "/orders";

    static final String ID_ID = "/{id}";

    static final String TOTAL = "/total";

    static final String OPERATOR = "/operator";

    private OrderBusinessController orderBusinessController;

    @Autowired
    public OrderResource(OrderBusinessController orderBusinessController) {
        this.orderBusinessController = orderBusinessController;
    }

    @PostMapping
    public OrderBasicDto create(@RequestBody OrderCreationDto orderCreationDto) {
        orderCreationDto.validate();
        return this.orderBusinessController.create(orderCreationDto);
    }

    @GetMapping
    public List<OrderBasicDto> readAll() {
        return this.orderBusinessController.readAll();
    }

    @GetMapping(value = ID_ID + TOTAL)
    public OrderBasicDto readTotal(@PathVariable String id) {
        return this.orderBusinessController.readOrder(id);
    }

    @GetMapping(value = ID_ID + OPERATOR)
    public OperatorDto readOperator(@PathVariable String id) {
        return this.orderBusinessController.readOperator(id);
    }

    @PutMapping(value = ID_ID + TOTAL)
    public void updateTotal(@PathVariable String id, @RequestBody OrderBasicDto orderBasicDto) {
        orderBasicDto.validate();
        this.orderBusinessController.updateTotal(id, orderBasicDto.getTotal());
    }

}