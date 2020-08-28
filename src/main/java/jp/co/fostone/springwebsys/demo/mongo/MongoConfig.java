//package jp.co.fostone.springwebsys.demo.mongo;
//
//import java.util.Arrays;
//
//import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import io.lettuce.core.ReadFrom;
//
///**
// *@author GuojieLi
// */
//@Configuration
//public class MongoConfig implements WebMvcConfigurer {
//
//	//MongoCustomConversions Bean
//	@Bean
//	public MongoCustomConversions mongoCustomConversions() {
//		return new MongoCustomConversions(Arrays.asList(new MoneyReadConverter()));
//	}
//
//	//RedisTemplate
//	@Bean
//	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//		RedisTemplate<String, Object> template = new RedisTemplate<>();
//		template.setConnectionFactory(redisConnectionFactory);
//		return template;
//	}
//	@Bean
//	public LettuceClientConfigurationBuilderCustomizer customizer() {
//		return builder -> builder.readFrom(ReadFrom.MASTER_PREFERRED);
//	}
//
//}
