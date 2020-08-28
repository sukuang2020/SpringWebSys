package jp.co.fostone.springwebsys.demo.redis;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.*;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import jp.co.fostone.springwebsys.jpa.entities.Player;
import jp.co.fostone.springwebsys.jpa.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
//@CacheConfig(cacheNames = "player-redis")
public class RedisDemoService {
    private static final String CACHE = "springbucks-player";
    @Autowired
    private RedisTemplate<String, Player> redisTemplate;

    @Autowired
    PlayerRepository playerRepository;

    public Optional<Player> findOne(String id) {
        HashOperations<String, String, Player> hashOperations = redisTemplate.opsForHash();
        if (redisTemplate.hasKey(CACHE) && hashOperations.hasKey(CACHE, id)) {
            log.info("Get from Redis.", id);
            return Optional.of(hashOperations.get(CACHE, id));
        }
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("id", exact().ignoreCase());
        Optional<Player> player = playerRepository.findOne(
                Example.of(Player.builder().id(id).build(), matcher));
        log.info("Player Found: {}", player);
        if (player.isPresent()) {
            log.info("Put player {} to Redis.", id);
            hashOperations.put(CACHE, id, player.get());
            redisTemplate.expire(CACHE, 1, TimeUnit.MINUTES);
        }
        return player;
    }
}
