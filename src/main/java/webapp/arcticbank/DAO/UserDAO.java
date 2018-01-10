package webapp.arcticbank.DAO;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import webapp.arcticbank.model.CreditCard;
import webapp.arcticbank.model.Deposit;
import webapp.arcticbank.model.User;
import webapp.arcticbank.session_manager.SessionManager;

public class UserDAO {
	public UserDAO() {
	}

	Session session = SessionManager.getSession();

	public void createNewUser(SessionFactory sessionFactory, User user) {
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

	public boolean checkIfUserExists(String first_name, String second_name) {
		User user = null;
		try {
			Query query = session.createQuery(
					"SELECT u from User u where u.first_name =:first_name and u.second_name =:second_name");
			query.setParameter("first_name", first_name);
			query.setParameter("second_name", second_name);
			user = (User) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return (user != null);
	}

	
	public User checkForLogin(String email, String password) {
		User user = null;
		try {
			Query query = session
					.createQuery("SELECT u from User u where u.email =:email and u.user_password =:password");
			query.setParameter("email", email);
			query.setParameter("password", password);
			user = (User) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return (user != null) ? user : null;
	}

	public List<User> getAllUsers() {
		List<User>users = null;
		try {
			Query query = session
					.createQuery("SELECT u from User u");
			users =  query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return (users != null) ? users : null;
	}

	

	

	public void deleteUser(User user) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(user);
			transaction.commit();
		} catch (HibernateException exc) {
			exc.printStackTrace();
			transaction.rollback();
		}
	}
}
