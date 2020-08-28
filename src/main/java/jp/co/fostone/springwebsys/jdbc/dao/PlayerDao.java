package jp.co.fostone.springwebsys.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import jp.co.fostone.springwebsys.jpa.entities.Player;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PlayerDao {

	// 使うデータソースを指定できる
	@Autowired //@Qualifier("jdbcTemplateSys1")
	JdbcTemplate jdbcTemplate;

	public int delete(String id) {
		return jdbcTemplate.update("DELETE FROM player where id=?", id);
	}
	public int delete1(String id) {
		return jdbcTemplate.update("DELETE FROM player swhere id=?", id);
	}

	public Player findById(String id) {
		Player player = jdbcTemplate.queryForObject("SELECT * FROM player where id=:id", Player.class, id);
		log.info(player.toString());
		return player;
	}

	public List<Player> findAll() {
		//return jdbcTemplate.queryForList("SELECT id,name,age,position,team FROM player", Object.class);
		return jdbcTemplate.query("SELECT id,name,age,position,team FROM player", (RowMapper<Player>) (rs, rowNum) -> Player.builder()
				.id(rs.getString(1))
				.name(rs.getString(2))
				.age(rs.getInt(3))
				.position(rs.getString(4))
				.team(rs.getString(5))
				.build());

//		List<Player> list = jdbcTemplate.query("SELECT id,name,age,position,team FROM player", new RowMapper<Player>() {
//
//			@Override
//			public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
//				// TODO 自動生成されたメソッド・スタブ
//				Player player = new Player();
//				player.setName(rs.getString(0));
//				return player;
//			}
//
//		});
//		return list;
	}
}
