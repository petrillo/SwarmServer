package swarm.server.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import swarm.server.domains.Invocation;

@RepositoryRestResource(collectionResourceRel = "invocations", path = "invocations")
public interface InvocationRepository extends PagingAndSortingRepository<Invocation, Long> {
	
	@Query("Select i from Invocation i Where i.session.id = :sessionId and i.invoking.id = :invokingId and i.invoked.id = :invokedId")
	List<Invocation> findByMethods(@Param("sessionId") Long sessionId, @Param("invokingId") Long invokingId, @Param("invokedId") Long invokedId);

	
}