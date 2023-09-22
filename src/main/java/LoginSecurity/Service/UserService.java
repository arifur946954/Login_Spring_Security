package LoginSecurity.Service;



import org.springframework.stereotype.Service;

import LoginSecurity.Entity.User;
@Service
public interface UserService {
	public User saveUser(User user);
	
	public void removeSessionMessage();

}
