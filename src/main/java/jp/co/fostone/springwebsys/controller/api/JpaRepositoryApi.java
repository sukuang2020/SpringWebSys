package jp.co.fostone.springwebsys.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.fostone.springwebsys.jpa.entities.Player;
import jp.co.fostone.springwebsys.service.PlayerService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/jparepository/")
@Slf4j
public class JpaRepositoryApi {
	@Autowired
	private PlayerService service;

	@GetMapping
	public List<Player> getList() {
		List<Player> players = service.findAll();
		return players;
	}
}
