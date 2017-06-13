package dao;

import model.StudentCourse;
import util.HQLUtil;

import java.util.List;

/**
 * Created by mevur on 6/12/2017.
 */
public class StudentCourseDao extends Dao {
    public boolean save(StudentCourse studentCourse) {
        return super.insert(studentCourse);
    }
    public boolean update(StudentCourse studentCourse) {
        return super.insert(studentCourse);
    }
    public boolean delete(StudentCourse studentCourse) {
        return super.delete(studentCourse);
    }
    public List<StudentCourse> query(String selection, String[] args) {
        String hql = HQLUtil.hql("StudentCourse", selection, args);
        return super.query(hql);
    }
}
