package io.mus.springdatajpabenmchark.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mustapha CHARBOUB
 * @since 1.0.0
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Table(name = "users")
public final class User extends BaseEntity {
	private String firstName;

	private String lastName;

	@ManyToOne(fetch = FetchType.LAZY)
	private Role role;

}
