package jp.co.fostone.springwebsys.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.fostone.springwebsys.jdbc.dao.PlayerDao;
import jp.co.fostone.springwebsys.jpa.entities.Player;
import jp.co.fostone.springwebsys.modal.ResultBean;
import jp.co.fostone.springwebsys.service.PlayerService;

@RestController
@RequestMapping("api/player")
public class PlayerRestController {
	@Autowired
	private PlayerService service;

	@Autowired
	PlayerDao dao;

	//JdbcTemplate
	@GetMapping
	public List<Player> getList() {
		List<Player> players = dao.findAll();
		return players;
	}

	@GetMapping(value = "/{id}")
	public Player getById(@PathVariable("id") String id) {
		return service.getOne(id);
	}

	@GetMapping(value = "/delete/{id}")
	public ResultBean delById(@PathVariable("id") String id) {
		service.delete(id);
		return ResultBean.success();
	}

	@GetMapping(value = "/test")
	public Player test() {
		Player player = dao.findById("");
		return player;
	}
}
