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


@WebServlet("/BalanceSetServlet")
public class BalanceSetServlet extends HttpServlet{
	
	
Logger logger = Logger.getLogger(CashTransferServlet.class);
	
	MoneyTransactionDAO moneyDAO = new MoneyTransactionDAO();
	UserDAO userDAO = new UserDAO();
	CreditCardDAO creditCardDAO = new CreditCardDAO();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String CardId = req.getParameter("card_id");
		Long id = Long.valueOf(CardId);

		String summ = req.getParameter("summ");
		BigDecimal balance = new BigDecimal(summ);
		System.out.println("summ = " + summ);
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/CashTransfer.jsp");
		PrintWriter out= resp.getWriter();
	
		
		
			
			 moneyDAO.balanceSet(id, balance);
			 rd = req.getRequestDispatcher("SuccesfullMoneyTransfer.html");
			 rd.forward(req, resp);
		
		
	}

}


