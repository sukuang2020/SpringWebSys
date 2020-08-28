//package jp.co.fostone.springwebsys.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//
///**
// * メインデータソース
// * @author GuojieLi
// *
// */
//@Configuration
//public class DataSourceCom {
//
//	@Bean(name = { "dsPropertyCom" })
//	@Primary
//	@ConfigurationProperties("spring.datasource.com")
//	public DataSourceProperties dsPropertyCom() {
//		return new DataSourceProperties();
//	}
//
//	@Bean(name = { "dsCom" })
//	@Primary
//	@Qualifier(value = "dsCom")
//	public DataSource dsCom(
//			@Qualifier("dsPropertyCom") DataSourceProperties properties) {
//		return properties.initializeDataSourceBuilder().build();
//	}
//
//	@Bean(name = { "txManagerCom" })
//	@Primary
//	@Qualifier(value = "txManagerCom")
//	public PlatformTransactionManager txManagerCom(@Qualifier("dsCom") DataSource ds) {
//		return new DataSourceTransactionManager(ds);
//	}
//
//	@Bean(name = "jdbcTemplateCom")
//	@Primary
//	@Qualifier(value = "jdbcTemplateCom")
//	public JdbcTemplate jdbcTemplateCom(@Qualifier("dsCom") DataSource ds) {
//		return new JdbcTemplate(ds);
//	}
//
//}
