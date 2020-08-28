package jp.co.fostone.springwebsys.controller.api;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.fostone.springwebsys.demo.mongo.Logger;
import jp.co.fostone.springwebsys.demo.mongo.LoggerService;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("api/mongo/")
@Slf4j
public class MongoApi {
	@Autowired
	private LoggerService service;

	@GetMapping("write")
	public String write() {
		Logger logger = Logger.builder()
				.id("2020-07-03 13:30:10.123")
				.type("INFO")
				.code("I00001")
				.name("テストメッセージ１")
				.price(Money.of(CurrencyUnit.of("CNY"), 20.0))
				.build();
		service.write(logger);

		service.write(Logger.builder()
				.id("2020-07-04 13:30:10.123")
				.type("INFO")
				.code("I00002")
				.name("テストメッセージ2")
				.price(Money.of(CurrencyUnit.of("CNY"), 25.3))
				.build());
		return "ok";
	}

	@GetMapping("readtype/{type}")
	public String readtype(@PathVariable String type) {
		service.readByType(type).forEach(l -> {
			log.info(l.toString());
		});
		return "ok";
	}

	@GetMapping("readid/{id}")
	public String readid(@PathVariable String id) {
//		log.info(service.readById(id).toString());
		return service.readById(id).toString();
	}


	@GetMapping("readtype/repo/{type}")
	public String repository1(@PathVariable String type) {
		service.readByTypeAsMongoRepository(type).forEach(l -> {
			log.info(l.toString());
		});
		return "ok";
	}
	@GetMapping("readtype/repo/obj/{id}")
	public String repository2(@PathVariable String id) {
		log.info(service.readByTypeAsMongoRepositoryExample(id).toString());;

		return "ok";
	}

}
