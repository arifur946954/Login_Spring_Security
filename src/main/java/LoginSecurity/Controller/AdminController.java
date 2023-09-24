package LoginSecurity.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import LoginSecurity.Entity.User;
import LoginSecurity.Repository.UserRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserRepository userRepo;
	
	
	@ModelAttribute
	public String profile( Principal p, Model m) {
		String email= p.getName();
	User user=	userRepo.findByEmail(email);
	m.addAttribute("user", user); 
		return "adminProfile";
	}
	
	
	@GetMapping("/profile")
	public String adminProfile() {
		return "adminProfile";
	}
}
