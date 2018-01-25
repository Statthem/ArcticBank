package webapp.arcticbank.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import webapp.arcticbank.model.User;

@WebListener
public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession session =  arg0.getSession();
		User user;
		if(session.getAttribute("current_user") != null){
    		user = (User) session.getAttribute("current_user");
    		session.getServletContext().removeAttribute(user.getEmail());
    		}
	}

}
