package jp.co.fostone.springwebsys.controller.api;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import jp.co.fostone.springwebsys.mybatis.mapper.CoffeeMapper;
import jp.co.fostone.springwebsys.mybatis.modal.Coffee;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/mybatis/")
@Slf4j
public class MybatisApi {
	@Autowired
	private CoffeeMapper coffeeMapper;

	@GetMapping("1")
	public String test1() {

		PageHelper.startPage(1, 2).doSelectPage(() -> coffeeMapper.findAll())
		.forEach(c -> log.info("Page(1) Coffee{}", c));
		log.info("===================");

		//		List<Coffee> list = coffeeMapper.sel

		coffeeMapper.findAllWithRowBounds(new RowBounds(1, 3))
				.forEach(c -> log.info("Page(1) Coffee {}", c));
		coffeeMapper.findAllWithRowBounds(new RowBounds(2, 3))
				.forEach(c -> log.info("Page(2) Coffee {}", c));

		log.info("===================");

		coffeeMapper.findAllWithRowBounds(new RowBounds(1, 0))
				.forEach(c -> log.info("Page(1) Coffee {}", c));

		log.info("===================");

		coffeeMapper.findAllWithParam(1, 3)
				.forEach(c -> log.info("Page(1) Coffee {}", c));
		List<Coffee> list = coffeeMapper.findAllWithParam(2, 3);
		PageInfo page = new PageInfo(list);
		log.info("PageInfo: {}", page);
		return "";
	}

	//	@GetMapping(path = "all")
	//	public List<User> getAll() {
	//		List<User> test = userService.getAll();
	//		return test;
	//	}

	//	@GetMapping(value = "/{id}")
	//	public User getById(@PathVariable("id") String id) {
	//		return userService.getById(id);
	//	}

	//	@GetMapping(value = "/{name}")
	//	public List<User> getByName(@PathVariable("name") String name) {
	//		return userService.getByName(name);
	//	}
}
