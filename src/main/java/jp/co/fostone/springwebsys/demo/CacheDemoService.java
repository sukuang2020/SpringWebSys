package jp.co.fostone.springwebsys.demo;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import jp.co.fostone.springwebsys.jpa.entities.Player;
import jp.co.fostone.springwebsys.jpa.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@CacheConfig(cacheNames = "player")
public class CacheDemoService {

	@Autowired
    private PlayerRepository playerRepository;

	@Cacheable
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @CacheEvict
    public void reloadPlayer() {
    }

    public Optional<Player> findOne(String name) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", exact().ignoreCase());
        Optional<Player> player = playerRepository.findOne(
                Example.of(Player.builder().name(name).build(), matcher));
        log.info("player Found: {}", player);
        return player;
    }
}
