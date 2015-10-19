package swarm.server.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import swarm.server.domains.Project;


@RepositoryRestResource(collectionResourceRel = "projects", path = "projects")
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
	Project findByName(@Param("name") String name);
	
	List<Project> findAll();
	
	@Query("Select distinct s.project from Session s where s.developer.id = :id") 
	List<Project> findByDeveloperId(@Param("id") Long id);
}