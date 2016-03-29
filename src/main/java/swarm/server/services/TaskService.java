package swarm.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import swarm.server.domains.Session;

@Service
public class TaskService {

	@Autowired
	private TaskRepository  repository; 

	@Autowired
	private SessionRepository  sessionRepository; 
	
	@Autowired
	private SessionService sessionService; 
	
	public String findAll() {
		Gson gson = new Gson();
		return gson.toJson(repository.findAll());
	}
	
	public String getGraphData(Long taskId) {
		String graph = "[";
		
		List<Session> sessions = sessionRepository.findByTask(taskId);
		for (Session session : sessions) {
			graph += sessionService.getGraphData(session, false, false);
		}
		
		return graph + "]";
	}
}
