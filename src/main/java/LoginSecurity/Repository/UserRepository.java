package LoginSecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import LoginSecurity.Entity.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer>{
	//we can access all feture jparepositpry to userRepository like 
	//save, add, crud etc
	
	public User findByEmail(String email);//2nd step for authentication

}
