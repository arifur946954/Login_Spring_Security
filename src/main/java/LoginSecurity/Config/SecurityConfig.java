package LoginSecurity.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.http.HttpSession;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	public CustomAuthSuccessHandaller successHandaler;
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public UserDetailsService getDetailService()
	{
		return new CustomUserDetailService();
	}
	@Bean
	public DaoAuthenticationProvider getAuthenticationProvider() {
	DaoAuthenticationProvider daoAthenticationProvider=	new DaoAuthenticationProvider();
	daoAthenticationProvider.setUserDetailsService(getDetailService());
	daoAthenticationProvider.setPasswordEncoder(passwordEncoder());
	return daoAthenticationProvider;
		
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		/*
		 * http.csrf().disable().authorizeHttpRequests()
		 * .requestMatchers("/","/register","/signin","/saveUser") .permitAll()
		 * .requestMatchers("/**") .authenticated() .and() .formLogin()
		 * .loginPage("/signin") .loginProcessingUrl("/userLogin") //
		 * .usernameParameter("email") .defaultSuccessUrl("/user/profile") .permitAll();
		 */
		
		http.csrf().disable().authorizeHttpRequests()
		.requestMatchers("/user/**").hasRole("USER")
		.requestMatchers("/admin/**").hasRole("ADMIN")
		.requestMatchers("/**").permitAll().and()
		.formLogin().loginPage("/signin").loginProcessingUrl("/userLogin")
		.successHandler(successHandaler)
		.and().logout().permitAll();
		
		
		return http.build();
	}
	
	

}
