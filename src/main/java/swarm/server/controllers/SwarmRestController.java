package swarm.server.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;

@RestController
public class SwarmRestController {

	@RequestMapping("/")
    public String index() {
        return "Welcome to Swarm Debugging Server Infraestructure!";
    }
	
	@RequestMapping("/teste")
    public String teste() {
        return "teste";
    }
	
	@RequestMapping("/login")
    public String login() {
		Map<String, String> data = new HashMap<String, String>();
		data.put("id", "1");
		data.put("name", "Rodrigo");
		Gson gson = new Gson(); 
		String json = gson.toJson(data);
		System.out.println(json);
        return json;
    }
	
	@RequestMapping("/serverStatus")
    public String serverStatus() {
        return "OK";
    }
	
	@RequestMapping("/developer/projects")
    public String getProjects() {
		Map projects[] = new Map[1]; 
		Map<String, String> project = new HashMap<String, String>();
		project.put("id", "1");
		project.put("name", "jEdit");
		projects[0] = project;
		Gson gson = new Gson(); 
		String json = gson.toJson(projects);
		System.out.println(json);
        return json;
    }
	
	@RequestMapping("/session/sessions")
    public String getSessions() {
		Map sessions[] = new Map[1]; 
		Map<String, String> session = new HashMap<String, String>();
		session.put("id", "1");
		session.put("label", "Primeiro teste");
		session.put("description", "Descrição do primeiro teste");
		session.put("purpose", "teste");
		session.put("started", "2015-10-20T00:00:00Z");
		session.put("finished", "2015-10-21T00:00:00Z");
		session.put("project", "1");
		session.put("developer", "1");
		sessions[0] = session;
		Gson gson = new Gson(); 
		String json = gson.toJson(sessions);
		System.out.println(json);
        return json;
    }
	
}
