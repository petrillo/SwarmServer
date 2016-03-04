package swarm.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class TaskService {

	@Autowired
	private TaskRepository  repository; 
	
	public String findAll() {
		Gson gson = new Gson();
		return gson.toJson(repository.findAll());
	}
}
