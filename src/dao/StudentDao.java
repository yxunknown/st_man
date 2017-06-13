package dao;

import model.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HBNUtil;
import util.HQLUtil;

import java.util.List;

/**
 * Created by mevur on 6/11/2017.
 */
public class StudentDao extends Dao {
    public boolean save(Student student) {
        return super.insert(student);
    }
    public boolean update(Student student) {
        return super.update(student);
    }
    public boolean delete(Student student) {
        return super.delete(student);
    }
    public List<Student> query(String selection, String[] args) {
        String hql = HQLUtil.hql("Student", selection, args);
        List<Student> students = super.query(hql);
        return students;
    }
}
