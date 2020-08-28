package jp.co.fostone.springwebsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.fostone.springwebsys.jpa.entities.User;
import jp.co.fostone.springwebsys.service.UserService;

@Controller
@RequestMapping("adminap/user")
public class UserController {
	@Autowired
	private UserService service;

	@GetMapping("")
	public String init(@PageableDefault(size = 10) Pageable pageable, Model model) {
		Page<User> page = service.findAll(pageable);
		model.addAttribute("page", page);
		return "adminap/user";
	}

	@GetMapping("all")
	public String all(Model model) {
		//		List<User> users = service.getAll();
		//		model.addAttribute("userList", users);

		User user = new User();
		user.setId("admin");
		user.setName("admin");
		user.setEmail("admin@yahoo.co.jp");
		model.addAttribute("user", user);
		return "adminap/user";
	}

	@GetMapping("{id}")
	public String show(Model model, @PathVariable String id) {
		User user = service.findById(id);
		model.addAttribute("user", user);
		return "adminap/user";
	}

	/**
	 * データ削除
	 * @param id
	 * @return
	 */
	@DeleteMapping("{id}")
	public String del(@PathVariable String id) {
		service.delById(id);
		return "redirect:/adminap/user";
	}

	@GetMapping("deletetest")
	public String userDeleteTest() {
		service.delById("user10");
		return "";
	}

}
