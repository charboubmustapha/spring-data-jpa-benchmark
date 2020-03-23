package io.mus.springdatajpabenmchark.service;

import io.mus.springdatajpabenmchark.entity.Role;
import io.mus.springdatajpabenmchark.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Mustapha CHARBOUB
 * @since 1.0.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void deleteByRoleEquals(Role role) {
		userRepository.deleteByRoleEquals(role);
	}

	@Override
	public void deleteByRole(Role role) {
		userRepository.deleteByRole(role);
	}

	@Override
	public void deleteByRoleId(Long roleId) {
		this.userRepository.deleteByRoleId(roleId);
	}

	@Override
	public void deleteByNativeQuery(Long roleId) {
		userRepository.deleteByNativeQuery(roleId);
	}
}
