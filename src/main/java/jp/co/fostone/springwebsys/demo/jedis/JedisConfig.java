//package jp.co.fostone.springwebsys.demo.jedis;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
///**
// *@author GuojieLi
// */
//@Configuration
//public class JedisConfig implements WebMvcConfigurer {
//
//	@Bean
//	@ConfigurationProperties("redis")
//	public JedisPoolConfig jedisPoolConfig() {
//		return new JedisPoolConfig();
//	}
//
//	@Bean(destroyMethod = "close")
//	public JedisPool jedisPool(@Value("${redis.host}") String host) {
//		return new JedisPool(jedisPoolConfig(), host);
//	}
//
//}
