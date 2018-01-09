package webapp.arcticbank.DAO;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import webapp.arcticbank.model.CreditCard;
import webapp.arcticbank.model.User;
import webapp.arcticbank.session_manager.SessionManager;

public class CreditCardDAO {

	public CreditCardDAO() {
	}

	Session session = SessionManager.getSession();

	public Long addCreditCard(User user,String pin_code,Long card_id) {
		Transaction transaction = null;
		CreditCard creditCard  = null;

		try {
			creditCard = new CreditCard();
			System.out.println("card id = " + card_id);
			creditCard.setCard_id(card_id);
			creditCard.setPin_code(pin_code);
			creditCard.setUser(user);
			creditCard.setBalance(BigDecimal.ZERO);
			transaction = session.beginTransaction();

			session.save(creditCard);
			transaction.commit();
		} catch (HibernateException exc) {
			exc.printStackTrace(System.out);
			transaction.rollback();
		}
		

		return creditCard.getCard_id();
	}

	public CreditCard getCardById(Long card_id) {
		CreditCard card = null;

		Query query = session.createQuery("SELECT c from CreditCard c where c.card_id=:card_id");
		query.setParameter("card_id", card_id);
        card = (CreditCard) query.uniqueResult();

		return card != null ? card : null;

	}
	
	
	@SuppressWarnings("unchecked")
	public Set<CreditCard> getUserCards(User user){
		Set<CreditCard> creditCards  = null;
		
		Query query = session.createQuery("Select c from CreditCard c where c.user=:user");
		query.setParameter("user", user);
		creditCards =  new HashSet(query.list());
		
		
		return creditCards != null ? creditCards : null;
	}

}
