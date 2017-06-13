package dao;

import model.StudentCourse;
import model.StudentSignCourse;
import util.HQLUtil;

import java.util.List;

/**
 * Created by mevur on 6/12/2017.
 */
public class StudentSignCourseDao extends Dao {
    public boolean save(StudentSignCourse studentSignCourse) {
        return super.insert(studentSignCourse);
    }
    public boolean update(StudentSignCourse studentSignCourse) {
        return super.insert(studentSignCourse);
    }
    public boolean delete(StudentSignCourse studentSignCourse) {
        return super.delete(studentSignCourse);
    }
    public List<StudentSignCourse> query(String selection, String[] args) {
        String hql = HQLUtil.hql("StudentSignCourse", selection, args);
        return super.query(hql);
    }
}
