package jp.co.fostone.springwebsys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jp.co.fostone.springwebsys.jpa.entities.Player;
import jp.co.fostone.springwebsys.jpa.repository.PlayerRepository;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Player getOne(String id) {
        return playerRepository.getOne(id);
    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public void delete(String id) {
        playerRepository.deleteById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void deleteByIds(String[] ids) {
    	for (String id : ids) {
    		playerRepository.deleteById(id);
    	}
    }

}
