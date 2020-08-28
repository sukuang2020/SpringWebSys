package jp.co.fostone.springwebsys.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.fostone.springwebsys.jdbc.dao.PlayerDao;
import jp.co.fostone.springwebsys.jpa.entities.Player;

@RestController
@RequestMapping("api/jdbctemplate/")
public class JdbcTemplateApi {
	@Autowired
	PlayerDao dao;

	@GetMapping
	public List<Player> getList() {
		List<Player> players = dao.findAll();
		return players;
	}
}
