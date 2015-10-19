package swarm.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import swarm.server.domains.Project;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository  repository; 

	public String findAll() {
		Gson gson = new Gson();
		return gson.toJson(repository.findAll());
	}
	
	public String getProjects(Long developerId) {
		List<Project> projects = repository.findByDeveloperId(developerId);
		
		Gson gson = new Gson();
        return gson.toJson(projects);
	}
}
