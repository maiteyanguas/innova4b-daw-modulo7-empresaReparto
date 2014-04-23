package innova4b.empresaReparto.login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		String uri = req.getRequestURI();
        if(isValidSession(session) || isValidUri(uri)){
        	chain.doFilter(request, response);
        }else{       	
            res.sendRedirect("/empresaReparto/login/new");
        }
	}
	
	private Boolean isValidSession(HttpSession session){
		return null!=session && null!=session.getAttribute("usuario");
	}
	
	private Boolean isValidUri(String uri){
		return uri.endsWith("/login/new") || uri.endsWith("/login/new.jsp") || uri.endsWith("/login/add") || uri.endsWith("css");
	}

	public void destroy() {}

	public void init(FilterConfig arg0) throws ServletException {}


}
