package io.mus.springdatajpabenmchark.service;

import java.util.concurrent.TimeUnit;

import io.mus.springdatajpabenmchark.configuration.RepositoryTestConfiguration;
import io.mus.springdatajpabenmchark.entity.Role;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(classes = RepositoryTestConfiguration.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class UserServiceTest {

	private static UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		UserServiceTest.userService = userService;
	}

	@Test
	public void runBenchmarks() throws Exception {
		Options opts = new OptionsBuilder()
				.include(String.format("\\.%s\\.", this.getClass().getSimpleName()))
				.warmupIterations(1)
				.measurementIterations(5)
				.forks(0)
				.threads(1)
				.shouldDoGC(true)
				.shouldFailOnError(true)
				.jvmArgs("-server", "-prof")
				.build();
		new Runner(opts).run();
	}

	@Benchmark
	public void deleteByNativeQuery() {
		userService.deleteByNativeQuery(4L);
	}

	@Benchmark
	public void deleteByRole() {
		Role role = new Role();
		role.setId(1L);
		userService.deleteByRole(role);
	}

	@Benchmark
	public void deleteByRoleId() {
		userService.deleteByRoleId(3L);
	}

	@Benchmark
	public void deleteByRoleEquals() {
		Role role = new Role();
		role.setId(2L);
		userService.deleteByRoleEquals(role);
	}

}
