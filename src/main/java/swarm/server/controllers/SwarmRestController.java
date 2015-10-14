package swarm.server.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;

@RestController
public class SwarmRestController {

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
}
