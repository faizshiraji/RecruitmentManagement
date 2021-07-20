package com.recruitmentmanagement.configure;

import java.io.IOException;
import java.rmi.AccessException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler  {
	

	protected String determineTargetUrl(Authentication authentication) {
		
		String url = "/login?error=true";

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		List<String> roles = new ArrayList<String>();
		for (GrantedAuthority a : authorities) {
			roles.add(a.getAuthority());
		}
		
		if (roles.contains("SITE_ADMIN")) {
			url = "/admin/home";
		}
		else if (roles.contains("SITE_USERS")) {
			url = "/users/index";
			
		}
		
		return url;
		
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String redirectUrl = determineTargetUrl(authentication);
		
		if (redirectUrl == null) {
			throw new AccessException(redirectUrl);
		}
		new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
	}
}
