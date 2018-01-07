package webapp.arcticbank.session_manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionManager {

	private static SessionFactory sessionFactory;
	private static Session session;

	public static boolean buildSessionFactory() {
		if (sessionFactory == null) {
			// Build a SessionFactory object from session-factory config
			// defined in the hibernate.cfg.xml file
			try {
				Configuration config = new Configuration();
				sessionFactory = config.configure().buildSessionFactory();
				session = sessionFactory.openSession();
				return true;
			} catch (Exception exc) {
				return false;
			}
		}
		return false;
	}
	
	public static SessionFactory getSessionFactory(){
		if(sessionFactory != null){
			return sessionFactory;
		}
		else{
			return null;
		}
	}

	public static Session getSession(){
		return session;
	}
  
	public static void closeSessionFactory(){
		sessionFactory.close();
	}
}
