package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by mevur on 6/11/2017.
 */
public class HBNUtil {
    private static SessionFactory sessionFactory;
    public static Session getSession() {
        if (sessionFactory == null || sessionFactory.isClosed()) {
            Configuration cfg = new Configuration();
            sessionFactory = cfg.configure().buildSessionFactory();
        }
        return sessionFactory.getCurrentSession();
    }
}
