package swarm.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import swarm.server.domains.Method;

@Service
public class MethodService {

	@Autowired
	private MethodRepository  repository; 

	public String getByTypeId(Long typeId) {
		Gson gson = new Gson();
		List<Method> methods = repository.findByTypeId(typeId);
        return gson.toJson(methods);
	}
}
