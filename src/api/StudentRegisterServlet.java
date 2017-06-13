package api;

import dao.StudentDao;
import model.Student;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by mevur on 6/11/2017.
 */
@WebServlet(name = "StudentRegisterServlet", urlPatterns = "/api/student/register")
public class StudentRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String school = request.getParameter("school");
        try {
            JSONObject obj = new JSONObject();
            obj.put("action", "student register");
            if (id == null || name == null || password == null || school == null) {
                obj.put("state", "1");
                obj.put("msg", "parameter[id, name, password, school] cannot be null");
            } else {
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setPassword(password);
                student.setSchool(school);
                StudentDao dao = new StudentDao();
                if (dao.save(student)) {
                    obj.put("state", "0");
                    obj.put("msg", "register success");
                } else {
                    obj.put("state", "1");
                    obj.put("msg", "register failed");
                }
            }
            PrintWriter writer = response.getWriter();
            writer.write(obj.toString());
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            JSONObject obj = new JSONObject();
            obj.put("state", "1");
            obj.put("action", "student register");
            obj.put("msg", "GET method is not allowed");
            PrintWriter writer = response.getWriter();
            writer.write(obj.toString());
            writer.flush();
            writer.close();
        } catch (JSONException e) {
            response.sendError(500, e.getMessage());
        }
    }
}
