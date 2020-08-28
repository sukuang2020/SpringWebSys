package jp.co.fostone.springwebsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.fostone.springwebsys.jdbc.dao.PlayerDao;

@Controller
public class HomeController {
	@Autowired
	PlayerDao playerDao;

	/**
	 * トップページへ
	 * @param model
	 * @return
	 */
	@GetMapping("/index")
	public String index(Model model) {
		playerDao.findById("");
		return "index";
	}

	/**
	 * ログインエラー画面へ
	 * @param email
	 * @param exception
	 * @param model
	 * @return
	 */
	@RequestMapping("/login_error")
	public String loginErr(
			@ModelAttribute("email") String email,
			@RequestAttribute(name = WebAttributes.AUTHENTICATION_EXCEPTION, required = false) Exception exception,
			Model model) {
		model.addAttribute("email", email);

		if (exception != null) {
			model.addAttribute("msg", exception.getMessage());
		}

		return "login";
	}

	/**
	 * Profile画面へ
	 * @param model
	 * @return
	 */
	@GetMapping("/myprofile")
	public String profileHome(Model model) {
		return "profile/myprofile";
	}

	/**
	 * 権限管理画面へ
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/role")
	public String roleHome(Model model) {
		return "admin/role";
	}

	/**
	 * ユーザー管理画面へ
	 * @param model
	 * @return
	 */
	@RequestMapping("/adminap/user")
	public String userHome(Model model) {
		return "adminap/user";
	}

	/**
	 * ユーザー権限管理画面へ
	 * @param model
	 * @return
	 */
	@RequestMapping("/adminap/userrole")
	public String userRoleHome(Model model) {
		return "adminap/userrole";
	}

}
