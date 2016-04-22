package swarm.server.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import swarm.server.services.ProductService;

@RestController
public class ProductRestController {

	@Autowired
	private ProductService service; 

	@RequestMapping("/products/paths")
    public String getProductPaths(@RequestParam(value = "productId", required=true) Long productId) {
		return service.getProductPaths(productId);
    }
}
