package es.upm.miw.apaw_ep_fernanda_guerra.operator_data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OperatorDao extends MongoRepository<Operator, String> {
}