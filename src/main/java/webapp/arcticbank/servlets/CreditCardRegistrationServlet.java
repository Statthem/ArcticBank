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

import webapp.arcticbank.DAO.CreditCardDAO;
import webapp.arcticbank.DAO.UserDAO;
import webapp.arcticbank.model.CreditCard;
import webapp.arcticbank.model.User;

@WebServlet("/CreditCardRegistrationServlet")
public class CreditCardRegistrationServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6406403004582979660L;
	
	Logger logger = Logger.getLogger(CreditCardRegistrationServlet.class);
	ServletContext context;
	CreditCardDAO creditCardDAO = new CreditCardDAO();
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		context = req.getServletContext();
        
		long card_id = 0;
		long cardId = 0;
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
		try {
		cardId = creditCardDAO.addCreditCard(user,pin_code,card_id);
		if(cardId > 0){
			logger.info("credit card registration succesfull");
			req.getSession().setAttribute("card_id", card_id);
			req.getRequestDispatcher("/CreditCardSuccesfullRegistration.jsp").forward(req, resp);
		}
		} catch (Exception e) {
			logger.info("exception was ocured while credit card registration:",e);
			e.printStackTrace(System.out);
		}
		if(card_id < 0)
		req.getRequestDispatcher("/CreditCardUnSuccesfullRegistration.html").forward(req, resp);
		

	}

	@Override
	public void init() throws ServletException {
		
				super.init();
	}

	
	
	
	private long generateCardId() {

		Random random = new Random();
		
		int[] numbers = new int[14];
		String id ="";
		for(int i = 0;i<numbers.length;i++){
			if(i == 0) numbers[i] = random.nextInt(8) + 1;
			numbers[i] = random.nextInt(9) + 0;
			id = id + String.valueOf(numbers[i]);
		}
				
		long cardId = Long.parseLong(id);
		
		return cardId;
	}

}
