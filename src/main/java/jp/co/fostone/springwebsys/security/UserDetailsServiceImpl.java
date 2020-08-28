package jp.co.fostone.springwebsys.security;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.fostone.springwebsys.jdbc.dao.UserDao;
import jp.co.fostone.springwebsys.jpa.entities.Role;
import jp.co.fostone.springwebsys.jpa.entities.User;
import jp.co.fostone.springwebsys.jpa.repository.RoleRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

//	@Autowired
//	private UserRepository userRepository;

	@Autowired
	UserDao userDao;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
//		User user = userRepository.getOne(id);
		User user = userDao.findById(id);
		if (user == null) {
			new UsernameNotFoundException("No User:" + id);
		}
		List<Role> roleList = roleRepository.findByUserId(id);
		return new org.springframework.security.core.userdetails.User(user.getId(), user.getPassword(),
				getAuthorities(roleList));
	}

	private static Collection<? extends GrantedAuthority> getAuthorities(List<Role> roleList) {
		String[] userRoles = roleList.stream().map((role) -> role.getName()).toArray(String[]::new);
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
		return authorities;
	}
}
