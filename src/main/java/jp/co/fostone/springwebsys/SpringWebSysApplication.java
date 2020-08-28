package jp.co.fostone.springwebsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication



public class SpringWebSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebSysApplication.class, args);
	}
//
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		generateArtifacts();
//	}
//
//	private void generateArtifacts() throws Exception {
//		List<String> warnings = new ArrayList<>();
//		ConfigurationParser cp = new ConfigurationParser(warnings);
//		Configuration config = cp.parseConfiguration(
//				this.getClass().getResourceAsStream("/generatorConfig.xml"));
//		DefaultShellCallback callback = new DefaultShellCallback(true);
//		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
//		myBatisGenerator.generate(null);
//	}
}
