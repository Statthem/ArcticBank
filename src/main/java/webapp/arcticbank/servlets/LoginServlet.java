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


import webapp.arcticbank.DAO.UserDAO;
import webapp.arcticbank.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1825504014772176442L;

	UserDAO userDao = new UserDAO();
    
	static Logger logger = Logger.getLogger(LoginServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// get request parameters for email and password
				String email = req.getParameter("user_email");
				String password = req.getParameter("password");
				
				
				User user;
				SessionFactory sessionFactory = (SessionFactory)req.getServletContext().getAttribute("sessionFactory");
				if((user = userDao.checkForLogin(email, password)) != null){
					//user = userDao.checkForLogin(sessionFactory, email, password);
					 logger.info("user " + user.getEmail() + "authentification succesfull");
					HttpSession session = req.getSession();
					session.setAttribute("current_user",user);
					//setting session to expiry in 60 mins
					session.setMaxInactiveInterval(60*60);	
					req.getRequestDispatcher("/WelcomePage.jsp").forward(req, resp);
				
					//resp.sendRedirect("WelcomePage.jsp");
					
				}else{
					logger.info("problem with user authentification");
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/WelcomePage.jsp");
					PrintWriter out= resp.getWriter();
					out.println("<font color=red>Either email or password is wrong.</font>");
					rd.include(req, resp);
				}

			}

		
	}

