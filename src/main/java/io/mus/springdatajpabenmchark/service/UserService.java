package io.mus.springdatajpabenmchark.service;

import io.mus.springdatajpabenmchark.entity.Role;

/**
 * @author Mustapha CHARBOUB
 * @since 1.0.0
 */
public interface UserService {
	void deleteByNativeQuery(Long roleId);

	void deleteByRoleEquals(Role role);

	void deleteByRole(Role role);

	void deleteByRoleId(Long roleId);
}
