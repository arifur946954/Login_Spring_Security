package LoginSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LoginSecurity.Entity.User;
import LoginSecurity.Repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserRepository userRepo;
	@Override
	public User saveUser(User user) {
	User newuser=	userRepo.save(user);
		
		return newuser;
	}

}
