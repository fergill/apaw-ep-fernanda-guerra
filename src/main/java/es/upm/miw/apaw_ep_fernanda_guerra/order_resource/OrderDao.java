package es.upm.miw.apaw_ep_fernanda_guerra.order_resource;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderDao extends MongoRepository<Order, String> {
}
