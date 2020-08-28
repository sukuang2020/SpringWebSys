package jp.co.fostone.springwebsys.controller.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.fostone.springwebsys.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@RestController
@RequestMapping("api/jedis/")
@Slf4j
public class JedisApi {
	@Autowired
	private PlayerService service;

	@Autowired
	private JedisPool jedisPool;
	@Autowired
	private JedisPoolConfig jedisPoolConfig;

	@GetMapping("")
	public String init() {
		log.info(jedisPoolConfig.toString());

		try (Jedis jedis = jedisPool.getResource()) {
			service.findAll().forEach(p -> {
				jedis.hset("users", p.getName(), p.getPosition());
			});

			Map<String, String> menu = jedis.hgetAll("users");
			log.info("users: {}", menu);

			String admin = jedis.hget("users", "Grp92");
			log.info(admin);
		}
		return "ok";
	}

}
