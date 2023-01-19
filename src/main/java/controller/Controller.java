package controller;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
	// this method handles home page requests.
	@GetMapping("/index")
	public String home() {

		return "index";
	}
	
}
