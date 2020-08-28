package jp.co.fostone.springwebsys.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.fostone.springwebsys.jpa.entities.Role;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, String> {
	List<Role> findByUserId(@Param("userId") String userId);
}