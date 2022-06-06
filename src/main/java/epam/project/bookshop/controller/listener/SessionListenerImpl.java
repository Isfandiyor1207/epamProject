package epam.project.bookshop.controller.listener;

import epam.project.bookshop.pool.ConnectionPool;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebListener
public class SessionListenerImpl implements HttpSessionListener {
    static Logger logger= LogManager.getLogger();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.info(" ----------> sessionCreated: " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info(" ----------> sessionDestroyed: " + se.getSession().getId());
    }

}
