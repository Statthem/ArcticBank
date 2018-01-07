package webapp.arcticbank.listeners;

import java.io.File;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
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
		
	    //initialize  session factory
			try {
				SessionManager.buildSessionFactory();
				SessionFactory sessionFactory = SessionManager.getSessionFactory();
				context.setAttribute("sessionFactory", sessionFactory);
				if(sessionFactory != null) context.log("session factory configured succesfully");
				if(sessionFactory == null) context.log("session factory not configured!!!");
			} catch (Exception exc) {
				context.log("erorr was ocurred while configurung sessionFactory");
			}
			
			
        
      //initialize log4j
    	String log4jConfig = context.getInitParameter("log4j-config");
    	if(log4jConfig == null){
    		System.out.println("No log4j-config init param, initializing log4j with BasicConfigurator");
			BasicConfigurator.configure();
    	}else {
			String webAppPath = context.getRealPath("/");
			String log4jProp = webAppPath + log4jConfig;
			File log4jConfigFile = new File(log4jProp);
			if (log4jConfigFile.exists()) {
				System.out.println("Initializing log4j with: " + log4jProp);
				DOMConfigurator.configure(log4jProp);
			} else {
				System.err.println(log4jProp + " file not found, initializing log4j with BasicConfigurator");
				BasicConfigurator.configure();
			}
		}
    	System.out.println("log4j configured properly");
    	
    
		
    }
		
		
	}

