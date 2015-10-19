package swarm.server.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import swarm.server.domains.Method;

@RepositoryRestResource(collectionResourceRel = "methods", path = "methods")
public interface MethodRepository extends PagingAndSortingRepository<Method, Long> {

	@Query("Select m From Method m Where m.type.id = :typeId")
	List<Method> findByTypeId(@Param("typeId") Long typeId);

}