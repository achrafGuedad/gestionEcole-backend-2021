package com.project.Pfe.Pfe;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.Pfe.Pfe.entities.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthentificationFilter  extends UsernamePasswordAuthenticationFilter{
	

	private AuthenticationManager authenticationManager;
	
	public JWTAuthentificationFilter(AuthenticationManager authenticationManager) {

        super();
        this.authenticationManager = authenticationManager;
    }

@Override
public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
		throws AuthenticationException {
	User user = null;
    try {
        user = new ObjectMapper().readValue(request.getInputStream(),User.class);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    
    System.out.println("username"+user.getUsername());
    System.out.println("psw"+user.getPassword());
    return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
}



@Override
protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
		Authentication authResult) throws IOException, ServletException {

    org.springframework.security.core.userdetails.User springUser = (org.springframework.security.core.userdetails.User) authResult.getPrincipal();
   String jwt = Jwts.builder().setSubject(springUser.getUsername())
            .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
            .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET).claim("roles", springUser.getAuthorities()).compact();
    response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOCKEN_PREFIX + jwt);
}



}
