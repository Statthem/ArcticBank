package webapp.arcticbank.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import webapp.arcticbank.DAO.CreditCardDAO;
import webapp.arcticbank.DAO.MoneyTransactionDAO;
import webapp.arcticbank.DAO.UserDAO;
import webapp.arcticbank.model.CreditCard;

@WebServlet("/CashTransferServlet")
public class CashTransferServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7538952915124726515L;

	Logger logger = Logger.getLogger(CashTransferServlet.class);
	
	MoneyTransactionDAO moneyDAO = new MoneyTransactionDAO();
	UserDAO userDAO = new UserDAO();
	CreditCardDAO creditCardDAO = new CreditCardDAO();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Sourceid = req.getParameter("Scard_id");
		Long sourceCard_id = Long.valueOf(Sourceid);
		
		String destid = req.getParameter("Dcard_id");
		Long destCard_id = Long.valueOf(destid);

		String transferSumm = req.getParameter("summ");
		BigDecimal summ = new BigDecimal(transferSumm);
		
		CreditCard sourceCard = null;
		CreditCard destCard = null;
		
		RequestDispatcher rd = req.getRequestDispatcher("/CashTransfer.jsp");
		PrintWriter out= resp.getWriter();
		try{
			if(creditCardDAO.getCardById(destCard_id) == null){
				out.println("<font color=red>destination card id is wrong</font>");
		    rd.include(req, resp);
			}
			 sourceCard = creditCardDAO.getCardById(sourceCard_id);
			 destCard = creditCardDAO.getCardById(destCard_id);
		if(sourceCard != null && destCard != null){
			
			if(sourceCard.getBalance().compareTo(summ) < 0){
				out.println("<font color=red> you have not enough money at your balance </font>");
			    rd.include(req, resp);
			}
			
			 moneyDAO.moneyTransaction(sourceCard, destCard, summ);
			 rd = req.getRequestDispatcher("SuccesfullMoneyTransfer.html");
			 rd.forward(req, resp);
			 
		}
		
		
		}catch(HibernateException exc){
			logger.info("Hibernate exception while money transaction!!!", exc);
		}
		

	}

}
