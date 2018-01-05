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

		if(session != null){
			if(session.getAttribute("current_user") == null && uri.contains("Cabinet")){
				res.sendRedirect("WelcomePage.jsp");
				return;
			}
				if(session.getAttribute("current_user") == null && uri.contains("Card")){
					res.sendRedirect("WelcomePage.jsp");
					return;
				}

					// pass the request along the filter chain
					chain.doFilter(request, response);
					return;
				}
		if(session == null){
			if(uri.contains("Cabinet")){
				res.sendRedirect("WelcomePage.jsp");
			return;
			}
			if(uri.contains("Card")){
				res.sendRedirect("WelcomePage.jsp");
			return;
			}
			if(uri.contains("Transfer")){
				res.sendRedirect("WelcomePage.jsp");
			return;
			}
		
		else{
			chain.doFilter(request, response);
		}
		
		}


			}
			
		

		public void destroy() {

		}

	}
