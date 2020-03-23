package io.mus.springdatajpabenmchark;

import io.mus.springdatajpabenmchark.repository.UserRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "io.mus.springdatajpabenmchark")
public class RepositoryConfiguration {
}
