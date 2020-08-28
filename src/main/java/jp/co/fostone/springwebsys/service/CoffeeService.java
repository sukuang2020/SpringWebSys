package jp.co.fostone.springwebsys.service;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.fostone.springwebsys.mybatis.mapper.CoffeeMapper;
import jp.co.fostone.springwebsys.mybatis.modal.Coffee;
import jp.co.fostone.springwebsys.mybatis.modal.CoffeeExample;

//Mybatis
@Service("coffeeService")
@MapperScan("jp.co.fostone.springwebsys.mybatis.mapper")
public class CoffeeService {
	@Autowired
	private CoffeeMapper coffeeMapper;

	public void insert(Coffee coffee) {
		coffeeMapper.insert(coffee);
	}

	public Coffee selByKey(Long id) {
		return coffeeMapper.selectByPrimaryKey(id);
	}

	public List<Coffee> selByName() {
		CoffeeExample example = new CoffeeExample();
		example.createCriteria().andNameEqualTo("latte");
		return coffeeMapper.selectByExample(example);
	}
}
