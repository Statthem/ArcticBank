package webapp.arcticbank.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.tomcat.util.descriptor.web.ServletDef;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import webapp.arcticbank.DAO.UserDAO;
import webapp.arcticbank.model.CreditCard;
import webapp.arcticbank.model.User;

@WebServlet("/CreditCardRegistrationServlet")
public class CreditCardRegistrationServlet extends HttpServlet {
	Logger logger = Logger.getLogger(CreditCardRegistrationServlet.class);
	ServletContext context;
	UserDAO userDAO = new UserDAO();
	SessionFactory sessionFactory;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		context = req.getServletContext();
        
		long card_id = 0;
		String pin_code = null;
		int pin = 0;

		try {
			pin_code = req.getParameter("pin_code");
			pin = Integer.parseInt(pin_code);
			card_id = generateCardId();

		} catch (NullPointerException | NumberFormatException exc) {
			exc.printStackTrace(System.out);
		}

		User user = (User) req.getSession().getAttribute("current_user");
		CreditCard creditCard = new CreditCard();
		creditCard.setCard_id(card_id);
		creditCard.setPin_code(pin);
		try {
			userDAO.addCreditCard(user, creditCard);
			logger.info("credit card registration succesfull");
		} catch (HibernateException e) {
			logger.info("exception was ocured while credit card registration:",e);
			e.printStackTrace(System.out);
		}
		
		req.getRequestDispatcher("CreditCardSuccesfullRegistration.jsp").forward(req, resp);

	}

	@Override
	public void init() throws ServletException {
		sessionFactory = (SessionFactory) this.getServletContext().getAttribute("sessionFactory");
		super.init();
	}

	private long generateCardId() {

		Random random = new Random();
		int number1 = random.nextInt(9) + 0;
		int number2 = random.nextInt(9) + 0;
		int number3 = random.nextInt(9) + 0;
		int number4 = random.nextInt(9) + 0;
		int number5 = random.nextInt(9) + 0;
		int number6 = random.nextInt(9) + 0;
		int number7 = random.nextInt(9) + 0;
		int number8 = random.nextInt(9) + 0;
		int number9 = random.nextInt(9) + 0;
		int number10 = random.nextInt(9) + 0;
		int number11 = random.nextInt(9) + 0;
		int number12 = random.nextInt(9) + 0;
		int number13 = random.nextInt(9) + 0;
		int number14 = random.nextInt(9) + 0;

		String id = String.valueOf(number1) + String.valueOf(number2) + String.valueOf(number3)
				+ String.valueOf(number4) + String.valueOf(number5) + String.valueOf(number6) + String.valueOf(number7)
				+ String.valueOf(number8) + String.valueOf(number9) + String.valueOf(number10)
				+ String.valueOf(number11) + String.valueOf(number12) + String.valueOf(number13)
				+ String.valueOf(number14);

		long cardId = Long.parseLong(id);
		
		return cardId;
	}

}
