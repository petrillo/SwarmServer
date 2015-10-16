package swarm.server.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import swarm.server.domains.Session;

@RepositoryRestResource(collectionResourceRel = "sessions", path = "sessions")
interface SessionRepository extends PagingAndSortingRepository<Session, Long> {

	Page<Session> findByLabel(@Param("label") String label, Pageable pageable);

	Session findByLabelAllIgnoringCase(@Param("label") String label);
}
