package LoginSecurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import LoginSecurity.Entity.User;
import LoginSecurity.Service.UserService;
import LoginSecurity.Service.UserServiceImpl;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
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
	@PostMapping("/saveUser")
	public String saveuser( @ModelAttribute User user,HttpSession session) {
		User user1=	userService.saveUser(user);
	
	if(user1!=null) {
		session.setAttribute("msg", "Registration successfully");
//		System.out.println("User Save SuccessFully");
		
	}
	else {
		session.setAttribute("msg", "Registration Failed pls try again");
		//System.out.println("Something ent wrong pls try again");
		
	}
		return "redirect:/register";
	}
	
	

}
