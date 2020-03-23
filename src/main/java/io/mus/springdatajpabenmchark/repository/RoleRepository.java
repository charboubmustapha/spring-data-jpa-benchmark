package io.mus.springdatajpabenmchark.repository;


import io.mus.springdatajpabenmchark.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mustapha CHARBOUB
 * @since 1.0.0
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
