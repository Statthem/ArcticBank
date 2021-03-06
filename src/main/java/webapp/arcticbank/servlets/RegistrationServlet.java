package webapp.arcticbank.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.tomcat.util.descriptor.web.ServletDef;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import webapp.arcticbank.DAO.UserDAO;
import webapp.arcticbank.model.User;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5585030335097371165L;
	
	Logger logger = Logger.getLogger(RegistrationServlet.class);
	ServletContext context;
	UserDAO userDAO = new UserDAO();
	SessionFactory sessionFactory;

	@Override
	public void init() throws ServletException {
		sessionFactory = (SessionFactory) this.getServletContext().getAttribute("sessionFactory");
		super.init();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		context = req.getServletContext();

		String first_name = null;
		String second_name = null;
		String email = null;
		String user_password = null;
		String post_index = null;
		String date = null;
		Date date_of_birthday = null;
		String country = null;

		try {
			first_name = req.getParameter("first_name");

			second_name = req.getParameter("second_name");

			email = req.getParameter("email");

			user_password = req.getParameter("user_password");

			post_index = req.getParameter("post_index");

			date = req.getParameter("date_of_birthday");
			date_of_birthday = Date.valueOf(date);

			country = req.getParameter("country");

		} catch (NullPointerException | IllegalArgumentException exc) {
			logger.info(exc.getMessage(),exc);
		}

		if (!userDAO.checkIfUserExists(first_name, second_name)) {
			User user = new User();
			user.setFirst_name(first_name);
			user.setSecond_name(second_name);
			user.setEmail(email);
			user.setUser_password(user_password);
			user.setPost_index(post_index);
			user.setDate_of_birthday(date_of_birthday);
			user.setCountry(country);
			try {
				userDAO.createNewUser(sessionFactory, user);
				logger.info("New user registered succesfully");
			} catch (HibernateException exc) {
				logger.info("exception while user registration ",exc);
			}
			
			req.getRequestDispatcher("SuccesfullRegistrationPage.html").forward(req, resp);

		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/RegistrationPage.html");
			PrintWriter out = resp.getWriter();
			out.println("<font color=red>You are alreay registered</font>");
			rd.include(req, resp);
		}

	}
	

	

}
