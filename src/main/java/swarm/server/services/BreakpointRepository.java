package swarm.server.services;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import swarm.server.domains.Breakpoint;

@RepositoryRestResource(collectionResourceRel = "breakpoints", path = "breakpoints")
public interface BreakpointRepository extends PagingAndSortingRepository<Breakpoint, Long> {


}