package swarm.server.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import swarm.server.domains.Breakpoint;
import swarm.server.domains.Product;
import swarm.server.domains.Task;
import swarm.server.domains.Type;

@RepositoryRestResource(collectionResourceRel = "breakpoints", path = "breakpoints")
public interface BreakpointRepository extends PagingAndSortingRepository<Breakpoint, Long> {

	@Query("Select b from Breakpoint b Where b.type = :type order by b.lineNumber")
	List<Breakpoint> findByType(@Param("type") Type type);
	
	@Query("Select b from Breakpoint b Where b.type.session.task = :task and b.type.fullName = :fullName order by b.lineNumber")
	List<Breakpoint> findByTaskAndType(@Param("task") Task task, @Param("fullName") String fullName);

	@Query("Select b from Breakpoint b Where b.type.fullName = :fullName order by b.lineNumber")
	List<Breakpoint> findByTypeFullName(@Param("fullName") String fullName);
	
	@Query("Select count(b) from Breakpoint b Where b.type.session.task = :task and b.type.fullName = :fullName")
	int countByTaskAndType(@Param("task") Task task, @Param("fullName") String fullName);


	int countByType(Type type);

	@Query("Select b from Breakpoint b Where b.type.session.task.id = :taskId order by b.lineNumber")
	List<Breakpoint> findByTaskId(@Param("taskId") Long taskId);
	
	@Query("Select b from Breakpoint b Where b.type.session.task.product = :product order by b.lineNumber")
	List<Breakpoint> findByProduct(@Param("product") Product product);

}