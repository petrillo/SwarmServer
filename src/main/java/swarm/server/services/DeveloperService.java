package swarm.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import swarm.server.domains.Developer;

@Service
public class DeveloperService {

	@Autowired
	private DeveloperRepository  repository; 

	public String login(String name) {
		Developer dev = repository.findByNameAllIgnoringCase(name);
		
		Gson gson = new Gson(); 
		String json = gson.toJson(dev);
        return json;
	}
}
