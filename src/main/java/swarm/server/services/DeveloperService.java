package swarm.server.services;

import com.google.gson.Gson;

import swarm.server.domains.Developer;

public class DeveloperService {

	public static String login(String name, DeveloperRepository developers) {
		Developer dev = developers.findByNameAllIgnoringCase(name);
		
		Gson gson = new Gson(); 
		String json = gson.toJson(dev);
        return json;
	}

}
