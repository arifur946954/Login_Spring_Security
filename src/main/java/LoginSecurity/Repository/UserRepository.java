package LoginSecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import LoginSecurity.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
