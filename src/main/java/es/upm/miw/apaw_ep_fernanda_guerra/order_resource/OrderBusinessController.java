package es.upm.miw.apaw_ep_fernanda_guerra.order_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.croqueta_resource.Croqueta;
import es.upm.miw.apaw_ep_fernanda_guerra.croqueta_resource.CroquetaDao;
import es.upm.miw.apaw_ep_fernanda_guerra.exceptions.NotFoundException;
import es.upm.miw.apaw_ep_fernanda_guerra.operator_data.Operator;
import es.upm.miw.apaw_ep_fernanda_guerra.operator_data.OperatorDao;
import es.upm.miw.apaw_ep_fernanda_guerra.operator_resource.OperatorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OrderBusinessController {

    private OrderDao orderDao;

    private OperatorDao operatorDao;

    private CroquetaDao croquetaDao;

    @Autowired
    public OrderBusinessController(OrderDao orderDao, OperatorDao operatorDao, CroquetaDao croquetaDao) {
        this.orderDao = orderDao;
        this.operatorDao = operatorDao;
        this.croquetaDao = croquetaDao;

    }

    public OrderBasicDto create(OrderCreationDto orderCreationDto) {
        Operator operator = this.operatorDao.findById(orderCreationDto.getOperatorId())
                .orElseThrow(() -> new NotFoundException("Operator id: " + orderCreationDto.getOperatorId()));
        Croqueta croqueta = this.croquetaDao.findById(orderCreationDto.getCroquetaId())
                .orElseThrow(() -> new NotFoundException("Croqueta id: " + orderCreationDto.getCroquetaId()));
        Order order = new Order(orderCreationDto.getTotal(), operator, croqueta);
        this.orderDao.save(order);
        return new OrderBasicDto(order);
    }

    private Order findOrderByIdAssured(String id) {
        return this.orderDao.findById(id).orElseThrow(() -> new NotFoundException("Order id: " + id));
    }

    public List<OrderBasicDto> readAll() {
        List<Order> orders = this.orderDao.findAll();
        return orders.stream().map(OrderBasicDto::new).collect(Collectors.toList());
    }

    public OrderBasicDto readOrder(String id) {
        return new OrderBasicDto(this.findOrderByIdAssured(id));
    }

    public OperatorDto readOperator(String id) {
        return new OperatorDto(this.findOrderByIdAssured(id).getOperator());
    }


    public void updateTotal(String id, Double total) {
        Order order = this.findOrderByIdAssured(id);
        order.setTotal(total);
        this.orderDao.save(order);
    }

}