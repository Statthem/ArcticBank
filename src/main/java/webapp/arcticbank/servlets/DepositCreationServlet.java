package webapp.arcticbank.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import webapp.arcticbank.DAO.DepositDAO;
import webapp.arcticbank.DAO.UserDAO;
import webapp.arcticbank.model.Deposit;
import webapp.arcticbank.model.User;

@WebServlet("/DepositCreationServlet")
public class DepositCreationServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 819534413159807433L;

	Logger logger = Logger.getLogger(DepositCreationServlet.class);
	
	DepositDAO depositDAO = new DepositDAO();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Sourceid = req.getParameter("Scard_id");
		Long sourceCard_id = Long.valueOf(Sourceid);

		String active_date = req.getParameter("active_date");
		System.out.println("date = " + active_date);
		Date expiration_date = expirationDate(active_date);

		long millis = System.currentTimeMillis();
		Date creation_date = new Date(millis);

		String summ = req.getParameter("summ");
		BigDecimal balance = new BigDecimal(summ);
		
		User user = (User) req.getSession().getAttribute("current_user");
		
		Deposit deposit = new Deposit();
		deposit.setCreation_date(creation_date);
		deposit.setExpiration_date(expiration_date);
		
		try{
	    depositDAO.createDeposit(user, deposit,sourceCard_id,balance);
		logger.info("new deposit created successfuly");
		}catch(Exception exc){
			logger.info("exception while creating new deposit",exc);
		}
		
		req.getRequestDispatcher("/SuccesfullDepositCreation.html").forward(req, resp);
	}

	private Date expirationDate(String active_date) {
		long millis = System.currentTimeMillis();
		Date expirationDate = new Date(millis);
        LocalDate local = null;
		switch (active_date) {
		case ("2 months"):
			local = expirationDate.toLocalDate().plusMonths(2);
			break;

		case ("6 months"):
			local =	expirationDate.toLocalDate().plusMonths(6);
			break;

		case ("1 year"):
			local = expirationDate.toLocalDate().plusMonths(12);
			break;

		case ("1,5 year"):
			local = expirationDate.toLocalDate().plusMonths(18);
			break;

		case ("3 years"):
			local = expirationDate.toLocalDate().plusMonths(36);
			break;
		}
           expirationDate = Date.valueOf(local);
			return expirationDate;

		}
	

}
