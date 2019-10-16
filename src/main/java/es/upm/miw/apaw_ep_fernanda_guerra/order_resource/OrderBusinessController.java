package es.upm.miw.apaw_ep_fernanda_guerra.order_resource;

import es.upm.miw.apaw_ep_fernanda_guerra.croqueta_data.Croqueta;
import es.upm.miw.apaw_ep_fernanda_guerra.croqueta_data.CroquetaDao;
import es.upm.miw.apaw_ep_fernanda_guerra.exceptions.NotFoundException;
import es.upm.miw.apaw_ep_fernanda_guerra.operator_data.Operator;
import es.upm.miw.apaw_ep_fernanda_guerra.operator_data.OperatorDao;
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
        Order order = new Order(orderCreationDto.getPrice(), operator, croqueta);
        this.orderDao.save(order);
        return new OrderBasicDto(order);
    }

    public List<OrderBasicDto> readAll() {
        List<Order> recipes = this.orderDao.findAll();
        return recipes.stream().map(OrderBasicDto::new).collect(Collectors.toList());
    }

    public OrderBasicDto readOrder(String id) {
        return new OrderBasicDto(this.findOrderByIdAssured(id));
    }

    private Order findOrderByIdAssured(String id) {
        return this.orderDao.findById(id).orElseThrow(() -> new NotFoundException("User id: " + id));
    }


}