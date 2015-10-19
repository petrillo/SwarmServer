package swarm.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import swarm.server.services.SessionService;

@RestController
public class SessionRestController {

	@Autowired
	private SessionService service;
	
	@RequestMapping("/sessions/find")
    public String findSessions(Long projectId, Long developerId) {
		return service.findSessions(projectId, developerId);
    }	
}
