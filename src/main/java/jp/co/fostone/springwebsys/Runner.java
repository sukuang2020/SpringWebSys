package jp.co.fostone.springwebsys;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class Runner {
	public static void main(String[] args) {
		Charset charset = StandardCharsets.UTF_8;
        String moji = "abcあいう123";

        //　エンコード
        byte[]a = Base64.getEncoder()
            .encode(moji.getBytes(charset));
        String en1 = new String(a, charset);
        System.out.println("en1= " + en1);
        // en1= YWJj44GC44GE44GGMTIz

        //　デコード
        byte[]b = Base64.getDecoder().decode(a);
        String de1 = new String(b,charset);
        System.out.println("de1= " + de1);
	}

	private void generateArtifacts() throws Exception {
		List<String> warnings = new ArrayList<>();
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(
				this.getClass().getResourceAsStream("/generatorConfig.xml"));
		DefaultShellCallback callback = new DefaultShellCallback(true);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
	}
}
