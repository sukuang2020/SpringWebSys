package jp.co.fostone.springwebsys.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.fostone.springwebsys.jpa.entities.User;
import jp.co.fostone.springwebsys.service.UserService;

/**
 * Exception Demo
 * @author GuojieLi
 *
 */
@RestController
@RequestMapping("api/exception/")
public class ExceptionApi {
	@Autowired
	private UserService service;

	@GetMapping("")
	public String test1() {
		// 存在するUserをInsert
		service.save(User.builder()
				.id("admin")
				.email("admin@yahoo.co.jp")
				.name("管理者")
				.password("$2a$10$Sx4akduFBd2mI0h0zzGQa.gbXqaeTQ.63rpNhXl301w3PqXNNsy3O")
				.build());
		return "";
	}

}
