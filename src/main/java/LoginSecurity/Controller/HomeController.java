package LoginSecurity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}
	
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	
	@GetMapping("/signin")
	public String login() {
		return "login";
	}
	
	

}
