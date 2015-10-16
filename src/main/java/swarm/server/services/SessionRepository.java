package swarm.server.services;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import swarm.server.domains.Developer;

@RepositoryRestResource(collectionResourceRel = "developers", path = "developers")
public interface SessionRepository extends PagingAndSortingRepository<Developer, Long> {

	
}