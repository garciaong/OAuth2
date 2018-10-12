package com.springboot.web.oauth2;

import java.security.Principal;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableOAuth2Sso
//@RestController
public class Oauth2SecurityConfig extends WebSecurityConfigurerAdapter{

//	@RequestMapping(value = "/message", method = RequestMethod.GET)
//	public String index() {
//		return "Spring Boot 2 is working!";
//	}

//	@RequestMapping("/user")
//	public Principal user(Principal principal) {
//		return principal;
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().antMatcher("/**").authorizeRequests()
		.antMatchers("/", "/login**", "/product/list", "/webjars/**", "/error**").permitAll()
				.anyRequest().authenticated()
				.and().logout().logoutSuccessUrl("/").permitAll();
	}
}
