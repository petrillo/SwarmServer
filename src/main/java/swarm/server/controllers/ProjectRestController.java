package swarm.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import swarm.server.services.ProjectService;

@RestController
public class ProjectRestController {

	@Autowired
	private ProjectService service; 

	@RequestMapping("/projects/all")
    public String findAll() {
		return service.findAll();
    }	
	
	@RequestMapping("/projects/getByDeveloperId")
    public String getProjects(Long developerId) {
		return service.getProjects(developerId);
    }	
}
