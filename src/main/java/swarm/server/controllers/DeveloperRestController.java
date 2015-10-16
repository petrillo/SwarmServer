package swarm.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import swarm.server.services.DeveloperRepository;
import swarm.server.services.DeveloperService;

@RestController
public class DeveloperRestController {

	@Autowired
	private DeveloperRepository  developers; 
	
	@RequestMapping("/login")
    public String login(String name) {
		return DeveloperService.login(name, developers);
    }
	
	@RequestMapping("/developer/projects")
    public String getProject(Long developerId) {
		return developerId.toString();
		//return DeveloperService.login(name, developers);
    }	
}
