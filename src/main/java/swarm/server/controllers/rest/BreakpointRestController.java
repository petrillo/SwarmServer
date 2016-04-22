package swarm.server.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import swarm.server.services.BreakpointService;

@RestController
public class BreakpointRestController {

	@Autowired
	private BreakpointService  service; 

	@RequestMapping("/breakpoints/breakpointsByTask")
    public String login(Long taskId) {
		return service.getByTaskId(taskId);
    }
	
	@RequestMapping("/breakpoints/all")
    public String getAll() {
		return service.getAll();
    }
	
	@RequestMapping("/breakpoints/fullTable")
    public String getFullTable(Long productId) {
		return service.getTable(productId);
    }

}
