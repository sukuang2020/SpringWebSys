package jp.co.fostone.springwebsys.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.fostone.springwebsys.jpa.entities.User;

@Repository
public class UserDao {

	//データソース指定できる
	@Autowired //@Qualifier("jdbcTemplateCom")
	JdbcTemplate jdbcTemplate;

	public User findById(String id) {
		String test =  jdbcTemplate.queryForObject("SELECT password FROM users WHERE id=?", String.class, id);
		User user = new User();
		user.setId(id);
		user.setPassword(test);
		return user;
	}

//	public User findById(String id) {
//		return jdbcTemplate.queryForObject("SELECT id,password FROM users WHERE id=?", new String[] { id },
//				new RowMapper<User>() {
//					@Override
//					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//						User user = new User();
//						user.setId(rs.getString(0));
//						user.setName(rs.getString(1));
//						return user;
//					}
//
//				});
//	}
}
