package webapp.arcticbank.listeners;

import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.SessionFactory;

import webapp.arcticbank.session_manager.SessionManager;

@WebListener
public class ContextListener implements ServletContextListener {

	public ContextListener() {
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		ServletContext context = arg0.getServletContext();
		try {
			SessionManager.closeSessionFactory();
		} catch (Exception exc) {
			context.log("erorr was ocurred while closing sessionFactory");
		}
		context.log("sessionFactory closed succesfully");

	}

	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext context = arg0.getServletContext();
        System.out.println("test");
		try {
			SessionManager.buildSessionFactory();
			SessionFactory sessionFactory = SessionManager.getSessionFactory();
			context.setAttribute("sessionFactory", sessionFactory);
			if(sessionFactory != null) context.log("session factory configured succesfully");
			if(sessionFactory == null) context.log("session factory not configured!!!");
		} catch (Exception exc) {
			context.log("erorr was ocurred while configurung sessionFactory");
		}
		
	}
}
