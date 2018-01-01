package webapp.arcticbank.DAO;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import webapp.arcticbank.model.CreditCard;
import webapp.arcticbank.model.User;
import webapp.arcticbank.session_manager.SessionManager;

public class UserDAO {
	public UserDAO(){}
	Session session = SessionManager.getSession();

	public void createNewUser(SessionFactory sessionFactory,User user){
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	public boolean checkIfUserExists(SessionFactory sessionFactory,String first_name,String second_name){
		User user = null;
		try {
		    Query query = session.createQuery("SELECT u from User u where u.first_name =:first_name and u.second_name =:second_name");
		    query.setParameter("first_name", first_name);
		    query.setParameter("second_name", second_name);
			 user = (User) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return (user != null);
	}
	
	public boolean checkIfCardExists(SessionFactory sessionFactory,Long card_id){
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

	public User checkForLogin(SessionFactory sessionFactory,String email,String password){
		User user = null;
		try {
		    Query query = session.createQuery("SELECT u from User u where u.email =:email and u.user_password =:password");
		    query.setParameter("email", email);
		    query.setParameter("password", password);
			 user = (User) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return (user != null) ? user : null;
	}
	
	public boolean addCreditCard(SessionFactory sessionFactory,User user,CreditCard creditCard){
		boolean flag = false;
		Transaction transaction = null;
		try{
			
			transaction = session.beginTransaction();
			
			Set<CreditCard> cardSet = user.getCredit_cards();
			cardSet.add(creditCard);
			System.out.println(cardSet.toArray()[0].toString());
			user.setCredit_cards(cardSet);
			
			session.update(user);
			transaction.commit();
			flag = true;
		}catch(HibernateException exc){
			exc.printStackTrace(System.out);
			transaction.rollback();
		}
		
		return flag;
	}
		
	public void deleteUser(SessionFactory sessionFactory,User user){
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			session.delete(user);
			transaction.commit();
		}catch(HibernateException exc){
			exc.printStackTrace();
			transaction.rollback();
		}
	}
}

