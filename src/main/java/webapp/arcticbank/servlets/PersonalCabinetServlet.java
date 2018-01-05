package webapp.arcticbank.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;

import webapp.arcticbank.DAO.UserDAO;
import webapp.arcticbank.model.User;

@WebServlet("/PersonalCabinetServlet")
public class PersonalCabinetServlet extends HttpServlet{
	UserDAO userDao = new UserDAO();
    
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	ServletContext	context = req.getServletContext();
	User user = null;	
	
		if(req.getSession().getAttribute("current_user")!=null){
			user = (User)req.getSession().getAttribute("current_user");
			context.log("authorized user - " + user.getFirst_name() );
			Hibernate.initialize(user.getCredit_cards());
			req.getRequestDispatcher("/PersonalCabinet.jsp").forward(req, resp);
					
				}else{
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/WelcomePage.jsp");
					rd.forward(req, resp);
				}

			}

		
	}

