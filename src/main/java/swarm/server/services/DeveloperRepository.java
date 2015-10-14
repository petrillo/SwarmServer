package swarm.server.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import swarm.server.domains.Developer;

@RepositoryRestResource(collectionResourceRel = "developers", path = "developers")
interface DeveloperRepository extends PagingAndSortingRepository<Developer, Long> {

	Page<Developer> findByName(@Param("name") String name, Pageable pageable);
	
	Developer findByNameAllIgnoringCase(@Param("name") String name);
}
