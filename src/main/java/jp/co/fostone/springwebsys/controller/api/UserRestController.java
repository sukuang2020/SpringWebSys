package jp.co.fostone.springwebsys.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.fostone.springwebsys.jpa.entities.User;
import jp.co.fostone.springwebsys.jpa.repository.UserRepository;

/**
 * JpaRepository Demo
 * @author GuojieLi
 *
 */
@RestController
@RequestMapping("api/adminap/user/")
public class UserRestController {
	@Autowired
	private UserRepository rep;

	@GetMapping(value = "{id}")
	public User getById(@PathVariable("id") String id) {
		return rep.getOne(id);
	}

	@GetMapping("")
	public String test(@PageableDefault(size = 10) Pageable pageable) {
		rep.findOrderByName("aaa", pageable);
		rep.findTop10OrderByName("bbb");
		rep.findByNameAndEmailOrderByName("", "", pageable);
		return "11";
	}

	@PostMapping
	public String create(User user) {
		rep.save(user);
		return "";
	}

	@GetMapping(path = "all")
	public List<User> getAll() {
		List<User> test = rep.findAll();
		return test;
	}

//	@GetMapping(value = "/{id}")
//	public User getById(@PathVariable("id") String id) {
//		return userService.getById(id);
//	}

//	@GetMapping(value = "/{name}")
//	public List<User> getByName(@PathVariable("name") String name) {
//		return userService.getByName(name);
//	}
}
