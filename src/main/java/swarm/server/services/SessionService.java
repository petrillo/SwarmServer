package swarm.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class SessionService {

	@Autowired
	private SessionRepository  repository; 
	
	public String findSessions(Long projectId, Long developerId) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();
		return gson.toJson(repository.findByProjectAndDeveloper(projectId, developerId));
	}
}
