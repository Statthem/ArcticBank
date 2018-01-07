package webapp.arcticbank.DAO;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import webapp.arcticbank.model.CreditCard;
import webapp.arcticbank.session_manager.SessionManager;

public class MoneyTransactionDAO {
	
	public MoneyTransactionDAO(){}
	
	Logger logger = Logger.getLogger(MoneyTransactionDAO.class);
	
	Session session = SessionManager.getSession();
	
	public void moneyTransaction(CreditCard sourceCard,CreditCard destCard,BigDecimal summ){
		Transaction transaction = null;
		
		try{
		transaction	= session.beginTransaction();
	    BigDecimal	sourceBalance = sourceCard.getBalance();
	    BigDecimal  destBalance = destCard.getBalance();
	    
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
	
		}catch(HibernateException exc){
			transaction.rollback();
			logger.info("exception while money transactions", exc);
			}
		}

}
