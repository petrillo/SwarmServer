package swarm.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class InvocationService {

	@Autowired
	private InvocationRepository  repository;

	public String getInvocationsByMethods(Long sessionId, Long invokingId, Long invokedId) {
		Gson gson = new Gson();
		return gson.toJson(repository.findByMethods(sessionId, invokingId, invokedId));

	} 
}
