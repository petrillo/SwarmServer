package swarm.server.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import swarm.server.domains.Breakpoint;
import swarm.server.domains.Session;
import swarm.server.domains.Task;
import swarm.server.domains.Type;

@Service
public class TaskService {

	@Autowired
	private TaskRepository  repository; 

	@Autowired
	private SessionRepository  sessionRepository; 
	
	@Autowired
	private TypeRepository  typeRepository;
	
	@Autowired
	private BreakpointRepository  breakpointRepository; 

//	@Autowired
//	private InvocationRepository  invocationRepository; 


	@Autowired
	private SessionService sessionService; 
	
	public String findAll() {
		Gson gson = new Gson();
		return gson.toJson(repository.findAll());
	}
	
	public String getGraphData(Long taskId) {
		String graph = "[";
		
		List<Session> sessions = sessionRepository.findByTask(taskId);
		for (Session session : sessions) {
			graph += sessionService.getGraphData(session, false, false);
		}
		
		return graph + "]";
	}
	
	public String getBreakpointGraphData(Long taskId) {
		return getBreakpointGraphData(taskId, true);
	}
	
	public String getBreakpointGraphData(Long taskId, boolean closed) {
		Task task = repository.findOne(taskId);
		if (task == null) {
			return "[]";
		}
		
		StringBuffer graph = new StringBuffer();
		
		if(closed) { 
			graph.append("[");
		}
		
		Map<String, Integer> typeNodes = new HashMap<String,Integer>();  
		List<Type> types = typeRepository.findByTask(task);
		for (Type type : types) {
			if(!typeNodes.containsKey(type.getFullName())) {
				int count = breakpointRepository.countByTaskAndType(task, type.getFullName());
				if(count > 0) {
					typeNodes.put(type.getFullName(),count);
				}
			}
		}
		
		List<String> nodes = sortNodes(typeNodes);
		for (String key : nodes) {
			String label = key.length() < 40 ? key : "..."+ key.substring(key.length() - 40, key.length()); 
			graph.append("{ \"data\": { \"id\": \"T" + key + "\", \"label\": \"" + label + "\", \"shape\": \"roundrectangle\", \"color\": \"#888\"}},");
		}
		
		
//		int r = 255;
//		int g = 255;
//		int b = 255;

		int x = 0;
		int pos = 0;
		

		for (String key : nodes) {
			int y = 0 + pos;
			//pos = pos == 0 ? 10 : 0;
			x += 150;

			List<Breakpoint> breakpoints = breakpointRepository.findByTaskAndType(task, key);
			for(Breakpoint breakpoint : breakpoints) {
				String devName = breakpoint.getType().getSession().getDeveloper().getName();

				//int hash = breakpoint.getType().getSession().getDeveloper().getName().hashCode();
				//int r = (hash & 0xFF0000) >> 16;
				//int g = (hash & 0x00FF00) >> 8;
				//int b = hash & 0x0000FF;
				
				
				y += 40;
				graph.append("{ \"data\": { \"id\": \"B" + breakpoint.getId() + "\", \"shape\": \"circle\", \"label\": \"" + (breakpoint.getLineNumber() + 1) + " " + devName +  "\", ");
				//graph.append("\"color\": \"" + String.format("#%02x%02x%02x", r, g, b) + "\"");
				//graph.append("\"color\": \"" + String.format("#%02x%02x%02x", r, g, b) + "\"");
				graph.append("\"dev\": " + breakpoint.getType().getSession().getDeveloper().getId() + ",");
				graph.append("\"color\": \"" + breakpoint.getType().getSession().getDeveloper().getColor() + "\",");
				
				graph.append("\"parent\": \"T" + key + "\"");
				graph.append("},");
				graph.append("\"position\": { \"x\": " + x + ", \"y\": " + y + "} },");
			}
		}

		
		String output;
		if(graph.length() > 2) {
			output =  graph.substring(0, graph.length() - 1) + (closed ? "]" : "");
		} else {
			output = graph.toString() + (closed ? "]" : "");
		}

		return output;
	}

	private List<String> sortNodes(Map<String, Integer> typeNodes) {
		List<String> nodes = new ArrayList<String>();

		Set<Entry<String,Integer>> entrySet = typeNodes.entrySet();
		System.out.println("Entry size " + entrySet.size());
		for (int i = 0; i <= entrySet.size(); i++) {
			String maxKey = "";
			int max = Integer.MIN_VALUE;

			for (Entry<String, Integer> entry : entrySet) {
				if(entry.getValue() > max && !nodes.contains(entry.getKey())) {
					maxKey = entry.getKey();
					max = entry.getValue();
				}
			}
			
			if(!maxKey.equals("") && !nodes.contains(maxKey)) {
				nodes.add(maxKey);
				System.out.println("Adding " + maxKey + " " + max);
			}
		}
		
		System.out.println("Node output size " + nodes.size());
		
		return nodes;
	}
}
