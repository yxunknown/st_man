package dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HBNUtil;

import java.util.List;

/**
 * Created by mevur on 6/11/2017.
 */
public abstract class Dao {
    protected boolean insert(Object o) {
        boolean how = false;
        Session session = HBNUtil.getSession();
        try {
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            how = true;
        } catch (Exception e) {
            e.printStackTrace();
            how = false;
        } finally {
            return how;
        }
    }

    protected boolean update(Object o) {
        boolean how = false;
        Session session = HBNUtil.getSession();
        try {
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
            how = true;
        } catch (Exception e) {
            e.printStackTrace();
            how = false;
        } finally {
             return how;
        }
    }
    protected boolean delete(Object o) {
        boolean how = false;
        Session session = HBNUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
            how = true;
        } catch (Exception e) {
            e.printStackTrace();
            how = false;
        } finally {
            return how;
        }
    }

    protected List query(String hql) {
        List result = null;
        Session session = HBNUtil.getSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery(hql);
            result = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
}
