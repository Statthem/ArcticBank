package webapp.arcticbank.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import webapp.arcticbank.model.Deposit;
import webapp.arcticbank.model.User;
import webapp.arcticbank.session_manager.SessionManager;

public class DepositDAO {
	public DepositDAO(){}

	Session session = SessionManager.getSession();
	
	public void createDeposit(User user, Deposit deposit) {
		Transaction transaction = null;
		


		try {
			deposit.setUser(user);
			transaction = session.beginTransaction();
			
			List<Deposit> deposits = user.getDeposits();
            deposits.add(deposit);
            user.setDeposits(deposits);
			session.update(user);
			transaction.commit();
		} catch (HibernateException exc) {
			exc.printStackTrace();
			transaction.rollback();
		}

	}

}
