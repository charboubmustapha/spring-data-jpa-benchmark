package io.mus.springdatajpabenmchark.repository;

import io.mus.springdatajpabenmchark.entity.Role;
import io.mus.springdatajpabenmchark.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Mustapha CHARBOUB
 * @since 1.0.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * delete the user by Role
	 *
	 * @param role the role of the user.
	 */
	void deleteByRole(Role role);

	/**
	 * alternative of {@link #deleteByRole(Role)} with equal condition
	 *
	 * @param role the role of the user.
	 */
	void deleteByRoleEquals(Role role);

	/**
	 * delete a user by a role if
	 *
	 * @param roleId the id of the role
	 */
	void deleteByRoleId(Long roleId);

	@Query(nativeQuery = true, value = "delete from users where role_id=?1")
	@Modifying
	void deleteByNativeQuery(Long roleId);

}
