package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/v1/all_books", "/v1/roles").hasAnyRole("USER","ADMIN").and().formLogin();
		
		/*permitAll().anyRequest().authenticated().and()
				.formLogin();*/
	//	http.csrf().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("dharmendra").password("password").roles("USER");
		  auth.inMemoryAuthentication().withUser("ram").password("ram123").roles("ADMIN");
	}
	
	
	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}

	
	 * @Bean
	 * 
	 * @Override public UserDetailsService userDetailsService() { UserDetails user
	 * =User.w User.withDefaultPasswordEncoder() .username("user")
	 * .password("password") .roles("USER") .build();
	 * 
	 * return new InMemoryUserDetailsManager(user); }
	 */
}