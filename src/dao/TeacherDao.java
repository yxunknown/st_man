package dao;

import model.Student;
import model.Teacher;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HBNUtil;
import util.HQLUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mevur on 6/11/2017.
 */
public class TeacherDao extends Dao {
    public boolean save(Teacher teacher) {
        return super.insert(teacher);
    }
    public boolean update(Teacher teacher) {
        return super.update(teacher);
    }
    public boolean delete(Teacher teacher) {
        return super.delete(teacher);
    }
    public List<Teacher> query(String selection, String[] args) {
        String hql = HQLUtil.hql("Teacher", selection, args);
        List<Teacher> teachers = super.query(hql);
        return teachers;
    }
}
