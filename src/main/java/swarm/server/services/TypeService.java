package swarm.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class TypeService {

	@Autowired
	private TypeRepository  repository;
	
	public String getBySessionId(Long sessionId) {
		Gson gson = new Gson();
		return gson.toJson(repository.findBySessionId(sessionId));
	}
}
