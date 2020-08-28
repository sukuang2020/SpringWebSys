package jp.co.fostone.springwebsys.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.fostone.springwebsys.jpa.entities.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, String> {
	//1 ソート：Name、Where：Name、size：指定
	Page<User> findOrderByName(String name, Pageable pageable);
	//2 1と同様A
	List<User> findTop10OrderByName(String name);

	//3 Where:Name, Email; Order:Name Paging
	Page<User> findByNameAndEmailOrderByName(String name, String email, Pageable pageable);

	List<User> findTop10ByPassword(String password);

}