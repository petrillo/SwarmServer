package swarm.server.services;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import swarm.server.domains.Namespace;

@RepositoryRestResource(collectionResourceRel = "namespaces", path = "namespaces")
public interface NamespaceRepository extends PagingAndSortingRepository<Namespace, Long> {

	Namespace findByFullPath(@Param("fullPath") String fullPath);

}