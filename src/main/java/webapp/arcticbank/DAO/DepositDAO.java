package webapp.arcticbank.DAO;

import java.math.BigDecimal;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.ServletException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import webapp.arcticbank.model.CreditCard;
import webapp.arcticbank.model.Deposit;
import webapp.arcticbank.model.User;
import webapp.arcticbank.session_manager.SessionManager;

public class DepositDAO {
	public DepositDAO(){}

	CreditCardDAO creditCardDAO = new CreditCardDAO();
	Session session = SessionManager.getSession();
	
	public boolean createDeposit(User user, Deposit deposit,Long card_id,BigDecimal balance){
		Transaction transaction = null;
		
        CreditCard creditCard = null;

		try {
			transaction = session.beginTransaction();
			deposit.setUser(user);
			deposit.setBalance(balance);
			
			creditCard = creditCardDAO.getCardById(card_id);
			
			BigDecimal newBalance = creditCard.getBalance().subtract(balance);
			creditCard.setBalance(newBalance);
			
			List<Deposit> deposits = user.getDeposits();
            deposits.add(deposit);
            user.setDeposits(deposits);
            
			session.update(user);
			transaction.commit();
			return true;
		} catch (HibernateException exc) {
			exc.printStackTrace();
			transaction.rollback();
		}
		return false;

	}
	
	public boolean createDeposit2(User user, Deposit deposit,Long card_id,BigDecimal balance){
		Transaction transaction = null;
		
        CreditCard creditCard = null;

		try {
			transaction = session.beginTransaction();
			deposit.setUser(user);
			deposit.setBalance(balance);
			
			creditCard = creditCardDAO.getCardById(card_id);
			
			BigDecimal newBalance = creditCard.getBalance().subtract(balance);
			creditCard.setBalance(newBalance);
			
			List<Deposit> deposits = user.getDeposits();
            deposits.add(deposit);
            user.setDeposits(deposits);
            
			session.update(user);
			transaction.commit();
			return true;
		} catch (HibernateException exc) {
			exc.printStackTrace();
			transaction.rollback();
		}
		return false;

	}


}
