package dao;

import model.Course;
import util.HQLUtil;

import java.util.List;

/**
 * Created by mevur on 6/12/2017.
 */
public class CourseDao extends Dao {
    public boolean save(Course course) {
        return super.insert(course);
    }
    public boolean update(Course course) {
        return super.update(course);
    }
    public boolean delete(Course course) {
        return super.update(course);
    }
    public List<Course> query(String selection, String[] args) {
        String hql = HQLUtil.hql("Course", selection, args);
        List<Course> courses = super.query(hql);
        return courses;
    }
}
