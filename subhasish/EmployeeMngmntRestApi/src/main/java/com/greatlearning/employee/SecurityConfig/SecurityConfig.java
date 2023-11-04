package com.greatlearning.employee.SecurityConfig;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

	@Configuration
	@EnableWebSecurity
	public class SecurityConfig extends WebSecurityConfigurerAdapter {

	    @Autowired
	    private UserDetailsService userDetailsService;

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	                .antMatchers("/api/roles/**").hasRole("ADMIN") // Only ADMIN can manage roles
	                .antMatchers("/api/users/**").hasRole("ADMIN") // Only ADMIN can manage users
	                .antMatchers("/api/employees/**").hasRole("ADMIN") // Only ADMIN can manage employees
	                .antMatchers("/api/employees/search/**").authenticated() // Authenticated users can search employees
	                .antMatchers("/api/employees/sort/**").authenticated() // Authenticated users can sort employees
	                .anyRequest().permitAll() // All other endpoints are open to everyone
	                .and()
	            .httpBasic() // Use basic authentication
	                .and()
	            .csrf().disable(); // Disable CSRF (for simplicity; you can enable it in production)

	        // Add any other security configurations you need
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	    }
	}

}
