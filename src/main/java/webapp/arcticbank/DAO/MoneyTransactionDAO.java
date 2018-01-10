package webapp.arcticbank.DAO;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import webapp.arcticbank.model.CreditCard;
import webapp.arcticbank.session_manager.SessionManager;

public class MoneyTransactionDAO {

	public MoneyTransactionDAO() {
	}

	Logger logger = Logger.getLogger(MoneyTransactionDAO.class);
	

	Session session = SessionManager.getSession();

	public void moneyTransaction(CreditCard sourceCard, CreditCard destCard, BigDecimal summ) {
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			BigDecimal sourceBalance = sourceCard.getBalance();
			BigDecimal destBalance = destCard.getBalance();

			sourceBalance.setScale(19, 4);
			destBalance.setScale(19, 4);
			summ.setScale(19, 4);

			sourceBalance = sourceBalance.subtract(summ);
			destBalance = destBalance.add(summ);

			sourceCard.setBalance(sourceBalance);
			destCard.setBalance(destBalance);

			session.update(sourceCard);
			session.update(destCard);
			session.flush();
			transaction.commit();

			logger.info("money transaction succesfull");

		} catch (HibernateException exc) {
			transaction.rollback();
			logger.info("exception while money transactions", exc);
		}
	}

	public void balanceSet(Long id, BigDecimal balance) {
		Transaction transaction = null;
		CreditCard creditCard = null;
		BigDecimal cardBalance = null;
		try {
			transaction = session.beginTransaction();
			creditCard = (CreditCard) session.get(CreditCard.class, id);

			if(creditCard == null) System.out.println("creditCard = null");
			cardBalance = creditCard.getBalance();
			
			System.out.println("cardBalance = " + cardBalance + " balance = " + balance);
			cardBalance = balance;
			creditCard.setBalance(cardBalance);
			session.update(creditCard);

			transaction.commit();

			logger.info("balance set sucessful");

		} catch (HibernateException | NullPointerException exc) {
			transaction.rollback();
			exc.printStackTrace(System.err);
			logger.info("exception while balance set", exc);
		}
	}
}
