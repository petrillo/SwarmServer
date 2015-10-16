package swarm.server.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import swarm.server.domains.Developer;
import swarm.server.domains.Project;

@RepositoryRestResource(collectionResourceRel = "projects", path = "projects")
interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

	Page<Project> findByName(@Param("name") String name, Pageable pageable);
	
	Project findByNameAllIgnoringCase(@Param("name") String name);
}
