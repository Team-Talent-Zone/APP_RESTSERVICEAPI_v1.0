package com.src.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

/**
 * The <code> CustomBasicAuthenticationEntryPoint </code> class defines Custom
 * Basic Authentication Entry point Details.
 * 
 * @author Ishaq
 * @version 1.0
 *
 */
public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	/**
	 * This method is for getting 401 error response.
	 */
	@Override
	public void commence(final HttpServletRequest request, final HttpServletResponse response,
			final AuthenticationException authException) throws IOException, ServletException {

		// response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		// response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");
		response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
		// PrintWriter writer = response.getWriter();
//		writer.println("HTTP Status 401 : " + authException.getMessage());
	}

	/**
	 * afterPropertiesSet.
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName("RESTAPI");
		super.afterPropertiesSet();
	}
}