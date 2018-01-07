package webapp.arcticbank.DAO;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import webapp.arcticbank.model.CreditCard;
import webapp.arcticbank.model.User;
import webapp.arcticbank.session_manager.SessionManager;

public class CreditCardDAO {
	
  public CreditCardDAO(){}
	
	Session session = SessionManager.getSession();
	
	
	
	public boolean addCreditCard(User user, CreditCard creditCard) {
		boolean flag = false;
		Transaction transaction = null;

		try {
			creditCard.setUser(user);
			transaction = session.beginTransaction();

			Set<CreditCard> cardSet = user.getCredit_cards();
			cardSet.add(creditCard);
			
			user.setCredit_cards(cardSet);

			session.update(user);
			transaction.commit();
			flag = true;
		} catch (HibernateException exc) {
			exc.printStackTrace(System.out);
			transaction.rollback();
		}

		return flag;
	}

	public CreditCard getCardById(Long card_id) {
		CreditCard card = null;
		if (checkIfCardExists(card_id)) {

			card = (CreditCard) session.get(CreditCard.class, card_id);

		}
		return card;

	}
	
	public boolean checkIfCardExists(Long card_id) {
		CreditCard card = null;
		try {
			Query query = session.createQuery("SELECT c from CreditCard c where c.card_id=:card_id");
			query.setParameter("card_id", card_id);
			card = (CreditCard) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return (card != null);
	}


}
