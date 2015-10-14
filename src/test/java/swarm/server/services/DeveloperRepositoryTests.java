package swarm.server.services;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import swarm.server.Application;
import swarm.server.domains.Developer;

/**
 * Integration tests for {@link CityRepository}.
 *
 * @author Oliver Gierke
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class DeveloperRepositoryTests {

	@Autowired
	DeveloperRepository repository;

	@Test
	public void findsFirstPageOfCities() {

		Page<Developer> developers = this.repository.findAll(new PageRequest(0, 10));
		assertThat(developers.getTotalElements(), is(greaterThan(1L)));
	}
}