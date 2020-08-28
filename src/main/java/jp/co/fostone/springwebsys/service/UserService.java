package jp.co.fostone.springwebsys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jp.co.fostone.springwebsys.jpa.entities.User;
import jp.co.fostone.springwebsys.jpa.repository.UserRepository;

@Service("userService")
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	public User findById(String id) {
		return userRepository.findById(id).orElse(null);
	}

	public void save(User user) {
		userRepository.save(user);
	}

	public void delById(String id) {
		userRepository.deleteById(id);
	}
}
