package jp.co.fostone.springwebsys.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

/**
 *@author GuojieLi
 */
@Configuration
@EnableCaching(proxyTargetClass = true)
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// /またはhomeの場合index画面へ遷移
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/home").setViewName("index");
		registry.addViewController("/login").setViewName("login"); //ログインページをカスタマイズする場合これを追加
	}

	@Bean
	public SpringSecurityDialect securityDialect() {
		return new SpringSecurityDialect();
	}

	@Bean
	public WebClient webClient(WebClient.Builder builder) {
		return builder.baseUrl("http://localhost:8080").build();
	}

	//	/**
	//	 * WebMvcConfigurer.getValidatorをOverrideしてメッセージをUTF-8にする
	//   * messageファイルをカスタマイズ
	//	 */
	//	@Override
	//	public Validator getValidator() {
	//		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
	//		// メッセージファイルを読込むための設定を記載します
	//		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	//		// 「setBasename」を使用することで任意のファイル名に変更することも可能です
	//		messageSource.setBasename("classpath:message");
	//		// 「setDefaultEncoding」を使用することで任意の文字コードに変更することも可能です
	//		messageSource.setDefaultEncoding("UTF-8");
	//		validator.setValidationMessageSource(messageSource);
	//		return validator;
	//	}

}
