package es.upm.miw.apaw_ep_fernanda_guerra.filler_resource;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FillerDao extends MongoRepository<Filler, String> {
}