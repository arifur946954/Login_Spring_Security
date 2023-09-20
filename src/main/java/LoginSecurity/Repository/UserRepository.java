package LoginSecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import LoginSecurity.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	//we can access all feture jparepositpry to userRepository like 
	//save, add, crud etc

}
