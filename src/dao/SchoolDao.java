package dao;

import model.School;
import util.HQLUtil;

import java.util.List;

/**
 * Created by mevur on 6/12/2017.
 */
public class SchoolDao extends Dao {
    public boolean save(School school) {
        return super.insert(school);
    }
    public boolean update(School school) {
        return super.update(school);
    }
    public boolean delete(School school) {
        return super.delete(school);
    }
    public List<School> query(String selection, String[] args) {
        String hql = HQLUtil.hql("School", selection, args);
        List<School> schools = super.query(hql);
        return schools;
    }
}
