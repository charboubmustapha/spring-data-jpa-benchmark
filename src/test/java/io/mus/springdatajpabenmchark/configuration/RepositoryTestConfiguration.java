package io.mus.springdatajpabenmchark.configuration;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.mus.springdatajpabenmchark.RepositoryConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.testcontainers.containers.PostgreSQLContainer;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@Import(RepositoryConfiguration.class)
@EnableConfigurationProperties(PostgresContainerProperties.class)
public class RepositoryTestConfiguration {
	private final PostgresContainerProperties properties;

	public RepositoryTestConfiguration(PostgresContainerProperties properties) {
		this.properties = properties;
	}

	@Bean(destroyMethod = "stop")
	PostgreSQLContainer<?> postgresContainer() {
		PostgresContainerProperties.Database databaseProperties = this.properties.getDatabase();
		PostgreSQLContainer<?> container = new PostgreSQLContainer<>(this.properties.getImageName())
				.withUsername(databaseProperties.getUsername())
				.withExposedPorts(databaseProperties.getPort())
				.withPassword(databaseProperties.getPassword())
				.withCreateContainerCmdModifier(createContainerCmd -> {
					createContainerCmd.withHostName(this.properties.getHostname());
					createContainerCmd.withName(this.properties.getName());
				});

		container.start();
		return container;
	}

	@Bean
	DataSource dataSource(PostgreSQLContainer<?> postgresContainer) {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setUsername(postgresContainer.getUsername());
		hikariConfig.setPassword(postgresContainer.getPassword());
		hikariConfig.setJdbcUrl(postgresContainer.getJdbcUrl());
		return new HikariDataSource(hikariConfig);

	}

}
