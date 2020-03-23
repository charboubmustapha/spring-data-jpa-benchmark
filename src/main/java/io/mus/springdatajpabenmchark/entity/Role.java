package io.mus.springdatajpabenmchark.entity;

import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public final class Role extends BaseEntity {
	private String value;
}
