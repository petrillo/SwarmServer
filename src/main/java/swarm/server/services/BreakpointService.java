package swarm.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import swarm.server.domains.Breakpoint;
import swarm.server.domains.Product;

@Service
public class BreakpointService {

	@Autowired
	private BreakpointRepository  repository; 

	@Autowired
	private ProductRepository  productRepository; 

	
	public String getByTaskId(Long taskId) {
		Gson gson = new Gson();
		List<Breakpoint> breakpoints = repository.findByTaskId(taskId);
        return gson.toJson(breakpoints);
	}
	
	public String getAll() {
		Gson gson = new Gson();
		Iterable<Breakpoint> breakpoints = repository.findAll();
        return gson.toJson(breakpoints);
	}

	public String getTable(Long productId) {
		Product product = productRepository.findOne(productId);
		List<Breakpoint> breakpoints = repository.findByProduct(product);

		StringBuffer buffer = new StringBuffer("{");
		long total = breakpoints.size();

		buffer.append("\"draw\": 1,\n");
		buffer.append("\"recordsTotal\": " + total + ",\n");
		buffer.append("\"recordsFiltered\": " + total + ",\n");
		buffer.append("\"data\": [\n");

		for (Breakpoint breakpoint : breakpoints) {
			buffer.append("[\"" + breakpoint.getType().getSession().getTask().getTitle().substring(0, 11) + "\",\n");
			buffer.append("\"" + breakpoint.getType().getSession().getDeveloper().getName() + "\",\n");
			buffer.append("\"" + breakpoint.getType().getFullName() + "\",\n");
			buffer.append("\"" + breakpoint.getLineNumber() + "\"],\n");
		}

		String output = buffer.toString().substring(0, buffer.toString().length() - 2);
		output = output + "\n]}";
        return output;
	}
}