package jp.co.fostone.springwebsys.demo.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoggerRepository extends MongoRepository<Logger, String> {
	List<Logger> findByType(String type);

}
