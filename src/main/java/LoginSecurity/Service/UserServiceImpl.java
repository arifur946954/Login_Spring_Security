package LoginSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import LoginSecurity.Entity.User;
import LoginSecurity.Repository.UserRepository;
import jakarta.servlet.http.HttpSession;
@Service

  public class UserServiceImpl implements UserService{
  
  @Autowired 
  private UserRepository userRepo;
  
  @Override 
  public User saveUser(User user) { 
	  User newuser= userRepo.save(user);
  
  return newuser; }

@Override
public void removeSessionMessage() {
HttpSession session=((ServletRequestAttributes)
		(RequestContextHolder.getRequestAttributes()))
         .getRequest().getSession();
          session.removeAttribute("msg");
	
}
  
  }
 




