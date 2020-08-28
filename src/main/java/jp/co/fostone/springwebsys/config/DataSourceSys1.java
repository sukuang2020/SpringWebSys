//package jp.co.fostone.springwebsys.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//
///**
// * Sys1業務用データソース
// * @author GuojieLi
// *
// */
//@Configuration
//
//public class DataSourceSys1 {
//
//	@Bean(name = { "dsPropertySys1" })
//	@ConfigurationProperties("spring.datasource.sys1")
//	public DataSourceProperties dsPropertySys1() {
//		return new DataSourceProperties();
//	}
//
//	@Bean(name = { "dsSys1" })
//	@Qualifier(value = "dsSys1")
//	public DataSource dsSys1(
//			@Qualifier("dsPropertySys1") DataSourceProperties properties) {
//		return properties.initializeDataSourceBuilder().build();
//	}
//
//	@Bean(name = { "txManagerSys1" })
//	@Qualifier(value = "txManagerSys1")
//	public PlatformTransactionManager txManagerSys1(@Qualifier("dsSys1") DataSource ds) {
//		return new DataSourceTransactionManager(ds);
//	}
//
//	@Bean(name = "jdbcTemplateSys1")
//	@Qualifier(value = "jdbcTemplateSys1")
//	public JdbcTemplate jdbcTemplateCom(@Qualifier("dsSys1") DataSource ds) {
//		return new JdbcTemplate(ds);
//	}
//
//}
