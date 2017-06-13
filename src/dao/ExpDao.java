package dao;

import model.Exp;
import util.HQLUtil;

import java.util.List;

/**
 * Created by mevur on 6/12/2017.
 */
public class ExpDao extends Dao {
    public boolean save(Exp exp) {
        return super.insert(exp);
    }
    public boolean update(Exp exp) {
        return super.update(exp);
    }
    public boolean delete(Exp exp) {
        return super.delete(exp);
    }
    public List<Exp> query(String selecion, String[] args) {
        String hql = HQLUtil.hql("Exp", selecion, args);
        List<Exp> exps = super.query(hql);
        return exps;
    }
}
