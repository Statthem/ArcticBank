package webapp.arcticbank.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/MainFilter")
public class MainFilter implements Filter {
	ServletContext context;

	public void init(FilterConfig fConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		context = request.getServletContext();
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		context.log("Requested Resource::"+uri);

		HttpSession session = req.getSession(false);

		if(session == null & (uri.contains("Succesfull"))){
			context.log("Unauthorized access request");
			res.sendRedirect("WelcomePage.jsp");
		}else{
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}


	}

	public void destroy() {
		
	}

}
