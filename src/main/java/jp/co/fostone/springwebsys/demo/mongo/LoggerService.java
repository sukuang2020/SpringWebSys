package jp.co.fostone.springwebsys.demo.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private LoggerRepository loggerMongoRepository;

	public void write(Logger logger) {
		mongoTemplate.save(logger);
	}

	public List<Logger> readByType(String type) {
		List<Logger> list = mongoTemplate.find(Query.query(Criteria.where("type").is(type)), Logger.class);
		return list;
	}

	public Logger readById(String id) {
		Logger logger = mongoTemplate.findById(id, Logger.class);
		return logger;
	}

	public List<Logger> readByTypeAsMongoRepository(String type) {
		return loggerMongoRepository.findByType(type);
	}

	public Logger readByTypeAsMongoRepositoryExample(String id) {
		return loggerMongoRepository.findOne(Example.of(Logger.builder().id(id).build())).orElse(null);
	}


}
