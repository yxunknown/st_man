package model;

import javax.persistence.*;

/**
 * Created by mevur on 6/11/2017.
 */
@Entity
@Table(name = "student_course", schema = "st_man", catalog = "")
public class StudentCourse {
    private int id;
    private String student;
    private String course;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "student", nullable = false, length = -1)
    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    @Basic
    @Column(name = "course", nullable = false, length = -1)
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentCourse that = (StudentCourse) o;

        if (id != that.id) return false;
        if (student != null ? !student.equals(that.student) : that.student != null) return false;
        if (course != null ? !course.equals(that.course) : that.course != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (student != null ? student.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        return result;
    }
}
