package webapp.arcticbank.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import com.mashape.unirest.request.HttpRequest;

import webapp.arcticbank.DAO.UserDAO;
import webapp.arcticbank.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1825504014772176442L;

	UserDAO userDao = new UserDAO();

	static Logger logger = Logger.getLogger(LoginServlet.class);
	
	
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user;
		
		// get request parameters for email and password
		String email = req.getParameter("user_email");
		String password = req.getParameter("password");
		
		//admin only params
		if(email.equals("admin@ukr.net") && password.equals("sasa1999")){
			session.setAttribute("admin", "admin");
            user =  new User();
            user.setFirst_name("admin");
            session.setAttribute("current_user", user);
            logger.info("admin  access");
            req.getRequestDispatcher("/WelcomePage.jsp").forward(req, resp);
		}

		
		
		if ((user = userDao.checkForLogin(email, password)) != null ) {

			if(alreadyIn(req, user)){
				req.getRequestDispatcher("/AlreadyIn.html").forward(req, resp);
				return;
			}
			logger.info("user " + user.getEmail() + " authentification succesfull");
			session.setAttribute("current_user", user);
			req.getServletContext().setAttribute(user.getEmail(), user);
			
			// setting session to expiry in 30 mins
			session.setMaxInactiveInterval(60 * 30);
			req.getRequestDispatcher("/WelcomePage.jsp").forward(req, resp);

		} else {
			logger.info("problem with user authentification");
			req.setAttribute("authentification", "false");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WelcomePage.jsp");

			rd.include(req, resp);
		}

	}
	
	private boolean alreadyIn(HttpServletRequest request,User user){
		boolean flag = false;
		
		if(request.getServletContext().getAttribute(user.getEmail()) != null){
			flag = true;
		}
		
		return flag;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("/ArcticBank/WelcomePage.jsp");
	}

}
