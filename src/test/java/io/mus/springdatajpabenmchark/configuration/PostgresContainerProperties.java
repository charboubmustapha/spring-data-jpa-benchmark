package io.mus.springdatajpabenmchark.configuration;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * configuration properties of the postgres container.
 *
 * @author Mustapha CHARBOUB
 * @since 1.0.0
 */
@ConfigurationProperties("container.postgres")
@ConstructorBinding
@Value
class PostgresContainerProperties {

	/**
	 * used to enable the postgres container.
	 */
	boolean enabled;

	/**
	 * the docker image name.
	 */
	String imageName;

	/**
	 * container host name.
	 */
	String hostname;

	/**
	 * container name.
	 */
	String name;

	/**
	 * database configuration properties.
	 */
	Database database;


	/**
	 * database configuration properties.
	 */
	@Value
	static class Database {

		/**
		 * the name of database.
		 */
		String name;

		/**
		 * the name of schemas.
		 */
		String schemaName;

		/**
		 * the exposed port.
		 */
		int port;

		/**
		 * the user name.
		 */
		String username;

		/**
		 * the password used to connect to database.
		 */
		String password;

	}

}
