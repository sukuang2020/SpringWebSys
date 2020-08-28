package jp.co.fostone.springwebsys.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;

import org.apache.ibatis.session.RowBounds;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

import com.github.pagehelper.PageHelper;

import jp.co.fostone.springwebsys.demo.CacheDemoService;
import jp.co.fostone.springwebsys.demo.mongo.Logger;
import jp.co.fostone.springwebsys.demo.mongo.LoggerService;
import jp.co.fostone.springwebsys.demo.redis.RedisDemoService;
import jp.co.fostone.springwebsys.jdbc.dao.PlayerDao;
import jp.co.fostone.springwebsys.jpa.entities.Player;
import jp.co.fostone.springwebsys.jpa.entities.User;
import jp.co.fostone.springwebsys.modal.ApiInfo;
import jp.co.fostone.springwebsys.mybatis.mapper.CoffeeMapper;
import jp.co.fostone.springwebsys.mybatis.modal.Coffee;
import jp.co.fostone.springwebsys.service.PlayerService;
import jp.co.fostone.springwebsys.service.UserService;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Controller
@RequestMapping("demo/")
@Slf4j
public class DemoListController {

	@GetMapping("clear")
	public String clear(Model model) {
		List<ApiInfo> infos = new ArrayList<ApiInfo>();
		model.addAttribute("infos", infos);
		return "profile/myprofile";
	}

	@Autowired
	private CacheDemoService cacheDemoService;

	@GetMapping("cache")
	public String init(Model model) {
		List<ApiInfo> infos = new ArrayList<ApiInfo>();
		infos.add(ApiInfo.builder().msg("redisDemoService.findAll() First Time").build());
		infos.add(ApiInfo.builder().msg(String.valueOf(cacheDemoService.findAll().size())).build());
		for (int i = 0; i < 10; i++) {
			infos.add(ApiInfo.builder().msg("Reading from cache."+i).build());
			cacheDemoService.findAll();
		}

		infos.add(ApiInfo.builder().msg("Clear cache").build());
		cacheDemoService.reloadPlayer();
		infos.add(ApiInfo.builder().msg("Reading from DB.").build());
		infos.add(ApiInfo.builder().msg(String.valueOf(cacheDemoService.findAll().size())).build());
		model.addAttribute("infos", infos);
		return "profile/myprofile";
	}

	//異常demo
	@Autowired
	private UserService expService;

	@GetMapping("exp")
	public String exp(Model model) {
		expService.save(null);
		return "profile/myprofile";
	}

	//JdbcTemplate Demo
	@Autowired
	PlayerDao dao;

	@GetMapping("jdbctemplate")
	public String jdbcTemplate(Model model) {
		List<ApiInfo> infos = new ArrayList<ApiInfo>();
		infos.add(ApiInfo.builder().msg("player.findAll").build());
		List<Player> players = dao.findAll();
		infos.add(ApiInfo.builder().msg("List size : " + String.valueOf(players.size())).build());
		model.addAttribute("infos", infos);
		return "profile/myprofile";
	}

	//Jedis Demo
	@Autowired
	private PlayerService playerService;
	@Autowired
	private JedisPool jedisPool;
	@Autowired
	private JedisPoolConfig jedisPoolConfig;
	@GetMapping("jedis")
	public String jedis(Model model) {
		List<ApiInfo> infos = new ArrayList<ApiInfo>();
		infos.add(ApiInfo.builder().msg("JedisPoolConfig:" + jedisPoolConfig.toString()).build());
		try (Jedis jedis = jedisPool.getResource()) {
			infos.add(ApiInfo.builder().msg("Player.findAll To Jedis").build());
			playerService.findAll().forEach(p -> {
				jedis.hset("users", p.getName(), p.getPosition());
			});

			Map<String, String> menu = jedis.hgetAll("users");
			infos.add(ApiInfo.builder().msg("Jedis users:" + menu.toString()).build());

			String admin = jedis.hget("users", "Grp92");
			infos.add(ApiInfo.builder().msg("get player.position From Jedis by users(name=Grp92):" + admin).build());
		}
		model.addAttribute("infos", infos);
		return "profile/myprofile";
	}

	//JpaTemplate Demo
	@GetMapping("jparepository")
	public String jparepository(Model model) {
		List<ApiInfo> infos = new ArrayList<ApiInfo>();
		infos.add(ApiInfo.builder().msg("player.findAll").build());
		List<Player> players = playerService.findAll();
		infos.add(ApiInfo.builder().msg("List size : " + String.valueOf(players.size())).build());
		model.addAttribute("infos", infos);
		return "profile/myprofile";
	}

	//Mongo Demo
//	docker start mongo
//	docker exec -it mongo bash
//	mongo -u admin -p admin
//
//	db.createUser(
//		{
//			user:"springbucks",
//			pwd:"springbucks",
//			roles:[
//				{role:"readWrite",db:"springbucks"}
//			]
//		}
//	);
	@Autowired
	private LoggerService mongoLogService;
	@GetMapping("mongo/mongotemplate/write")
	public String mogonwrite(Model model) {
		List<ApiInfo> infos = new ArrayList<ApiInfo>();
		Logger logger = Logger.builder()
				.id("2020-07-03 13:30:10.123")
				.type("INFO")
				.code("I00001")
				.name("テストメッセージ１")
				.price(Money.of(CurrencyUnit.of("CNY"), 20.0))
				.build();
		mongoLogService.write(logger);
		infos.add(ApiInfo.builder().msg("mongo write" + logger.toString()).build());

		mongoLogService.write(Logger.builder()
				.id("2020-07-04 13:30:10.123")
				.type("INFO")
				.code("I00002")
				.name("テストメッセージ2")
				.price(Money.of(CurrencyUnit.of("CNY"), 25.3))
				.build());
		infos.add(ApiInfo.builder().msg("mongo write" + logger.toString()).build());
		model.addAttribute("infos", infos);
		return "profile/myprofile";
	}

	@GetMapping("mogon/mongotemplate/readtype")
	public String readtype(Model model) {
		List<ApiInfo> infos = new ArrayList<ApiInfo>();
		infos.add(ApiInfo.builder().msg("mongo readByTypte(INFO)").build());
		mongoLogService.readByType("INFO").forEach(l -> {
			infos.add(ApiInfo.builder().msg("mongo get by type:" + l.toString()).build());
		});
		model.addAttribute("infos", infos);
		return "profile/myprofile";
	}

	@GetMapping("mogon/repo/readtype")
	public String repository1(Model model) {
		List<ApiInfo> infos = new ArrayList<ApiInfo>();
		infos.add(ApiInfo.builder().msg("mongo readByTypte(INFO)").build());
		mongoLogService.readByTypeAsMongoRepository("INFO").forEach(l -> {
			infos.add(ApiInfo.builder().msg("mongo get by type:" + l.toString()).build());
		});
		model.addAttribute("infos", infos);
		return "profile/myprofile";
	}

	//Mybatis Demo
	@Autowired
	private CoffeeMapper coffeeMapper;

	@GetMapping("mybatis")
	public String mybatis1(Model model) {
		List<ApiInfo> infos = new ArrayList<ApiInfo>();
		infos.add(ApiInfo.builder().msg("PageHelper.startPage(1, 2).doSelectPage:").build());
		PageHelper.startPage(1, 2).doSelectPage(() -> coffeeMapper.findAll()).forEach(c -> {
			infos.add(ApiInfo.builder().msg(c.toString()).build());
		});

		infos.add(ApiInfo.builder().msg("coffeeMapper.findAllWithRowBounds(new RowBounds(1, 3))").build());
		coffeeMapper.findAllWithRowBounds(new RowBounds(1, 3))
				.forEach(c -> infos.add(ApiInfo.builder().msg(c.toString()).build()));

		infos.add(ApiInfo.builder().msg("coffeeMapper.findAllWithRowBounds(new RowBounds(2, 3))").build());
		coffeeMapper.findAllWithRowBounds(new RowBounds(2, 3))
				.forEach(c -> infos.add(ApiInfo.builder().msg(c.toString()).build()));

		infos.add(ApiInfo.builder().msg("coffeeMapper.findAllWithRowBounds(new RowBounds(1, 0))").build());
		coffeeMapper.findAllWithRowBounds(new RowBounds(1, 0))
				.forEach(c -> infos.add(ApiInfo.builder().msg(c.toString()).build()));

		infos.add(ApiInfo.builder().msg("coffeeMapper.findAllWithParam(1, 3)").build());
		coffeeMapper.findAllWithParam(1, 3)
				.forEach(c -> infos.add(ApiInfo.builder().msg(c.toString()).build()));

		infos.add(ApiInfo.builder().msg("coffeeMapper.findAllWithParam(1, 3)").build());
		List<Coffee> list = coffeeMapper.findAllWithParam(2, 3);
		infos.add(ApiInfo.builder().msg(list.toString()).build());
		model.addAttribute("infos", infos);
		return "profile/myprofile";
	}


	//Redis
	@Autowired
	RedisDemoService redisDemoService;
	@GetMapping("redis/cache")
	public String rediscache(Model model) throws Exception {
		List<ApiInfo> infos = new ArrayList<ApiInfo>();
		infos.add(ApiInfo.builder().msg("redisDemoService.findOne First Time").build());

		Optional<Player> p = redisDemoService.findOne("Grp100");

		for (int i = 0; i < 5; i++) {
			infos.add(ApiInfo.builder().msg("redisDemoService.findOne from Redis").build());
			p = redisDemoService.findOne("Grp100");
		}
		model.addAttribute("infos", infos);
		return "profile/myprofile";
	}


	@Autowired
	WebClient webClient;
	@GetMapping("webflux")
	public String webFlux(Model model) throws InterruptedException {
		List<ApiInfo> infos = new ArrayList<ApiInfo>();

		CountDownLatch cdl = new CountDownLatch(2);

		webClient.get()
				.uri("/api/adminap/user/{id}", "admin")
				.retrieve()
				.bodyToMono(User.class)
//				.doOnError(t -> log.error("Error: ", t))
				.doFinally(s -> cdl.countDown())
				.subscribeOn(Schedulers.single())
				.subscribe(c -> {
					infos.add(ApiInfo.builder().msg(c.getName()).build());
				});

		Mono<User> li = Mono.just(User.builder().id("liguojie").name("liguojie").email("liguojie@yahoo.co.jp")
				.password("liguojie").build());
		webClient.post()
				.uri("/api/adminap/user/")
				.body(li, User.class)
				.retrieve()
				.bodyToMono(User.class)
				.doFinally(s -> cdl.countDown())
				.subscribeOn(Schedulers.single())
				.subscribe(c -> {
					infos.add(ApiInfo.builder().msg("insert li").build());
				});

		cdl.await();

		webClient.get()
				.uri("/api/adminap/user/all")
				.retrieve()
				.bodyToFlux(User.class)
				.toStream()
				.forEach(c -> {
					infos.add(ApiInfo.builder().msg(c.getName()).build());
				});

		model.addAttribute("infos", infos);
		return "profile/myprofile";
	}

}
