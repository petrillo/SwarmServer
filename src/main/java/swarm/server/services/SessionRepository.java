package swarm.server.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import swarm.server.domains.Session;

@RepositoryRestResource(collectionResourceRel = "sessions", path = "sessions")
public interface SessionRepository extends PagingAndSortingRepository<Session, Long> {

	@Query("Select s from Session s Where task.id = :taskId and developer.id = :developerId ")
	List<Session> findByTaskAndDeveloper(@Param("taskId") Long taskId, @Param("developerId") Long developerId);
	
}
