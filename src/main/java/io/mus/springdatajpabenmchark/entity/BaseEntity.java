package io.mus.springdatajpabenmchark.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mustapha CHARBOUB
 * @since 1.0.0
 */
@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode
abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

}
