package api;

import dao.TeacherDao;
import model.Teacher;
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
 * Created by mevur on 6/12/2017.
 */
@WebServlet(name = "TeacherRegisterServlet", urlPatterns = "/api/teacher/register")
public class TeacherRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String school = request.getParameter("school");
        String state = "";
        String action = "teacher register";
        String msg = "";
        try {
            if (id == null || name == null || password == null || school == null) {
                state = "1";
                msg = "parameter[id, name, password, school] is required";
            } else {
                TeacherDao dao = new TeacherDao();
                Teacher teacher = new Teacher();
                teacher.setId(id);
                teacher.setName(name);
                teacher.setPassword(password);
                teacher.setSchool(school);
                if (dao.save(teacher)) {
                    state = "0";
                    msg = "register success";
                } else {
                    state = "1";
                    msg = "register failed";
                }
                JSONObject obj = new JSONObject();
                obj.put("state", state);
                obj.put("action", action);
                obj.put("msg", msg);
                PrintWriter writer = response.getWriter();
                writer.write(obj.toString());
                writer.flush();
                writer.close();
            }
        } catch (JSONException e) {
            response.sendError(500, e.getMessage());
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            JSONObject obj = new JSONObject();
            obj.put("state", "1");
            obj.put("action", "teacher register");
            obj.put("msg", "GET method is not allowed");
            PrintWriter writer = response.getWriter();
            writer.write(obj.toString());
            writer.flush();
            writer.close();
        } catch (JSONException e) {
            e.printStackTrace();
            response.sendError(500, e.getMessage());
        }
    }
}
