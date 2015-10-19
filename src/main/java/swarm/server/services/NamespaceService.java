package swarm.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class NamespaceService {

	@Autowired
	private NamespaceRepository  repository;

	public String findbyFullPath(String fullPath) {
		Gson gson = new Gson();
		return gson.toJson(repository.findByFullPath(fullPath));
	} 

}
