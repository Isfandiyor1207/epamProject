package epam.project.bookshop.controller.listener;

import epam.project.bookshop.command.ParameterName;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebListener
public class SessionAttributeListenerImpl implements HttpSessionAttributeListener {
    static Logger logger= LogManager.getLogger();

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        logger.info(" ----------> attributeAdded: " + sbe.getSession().getAttribute(ParameterName.USERNAME));
        logger.info(" ----------> attributeAdded: " + sbe.getSession().getAttribute(ParameterName.PASSWORD));
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        logger.info(" ----------> attributeReplaced: " + sbe.getSession().getAttribute(ParameterName.USERNAME));
        logger.info(" ----------> attributeReplaced: " + sbe.getSession().getAttribute(ParameterName.PASSWORD));
    }
}
