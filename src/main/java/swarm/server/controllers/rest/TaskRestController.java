package swarm.server.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import swarm.server.services.TaskService;

@RestController
public class TaskRestController {

	@Autowired
	private TaskService service; 

	@RequestMapping("/tasks/all")
    public String findAll() {
		return service.findAll();
    }
	
	@RequestMapping("/tasks/graph")
    public String getGraphData(Long taskId) {
		return service.getGraphData(taskId);
    }	
}
