package jp.co.fostone.springwebsys.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.fostone.springwebsys.jpa.entities.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {

}
