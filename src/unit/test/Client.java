package unit.test;

import dao.StudentDao;
import model.Student;
import util.JsonUtil;

/**
 * Created by mevur on 6/12/2017.
 */
public class Client {
    public static void main(String[] args) {
        Student student = new Student();
        student.setId("1234");
        student.setName("name");
        student.setPassword("sdawe");
        student.setSchool("2");
        JsonUtil.beanToJSONOBJ(student);
    }
}
