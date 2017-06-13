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
import java.util.List;

/**
 * Created by mevur on 6/12/2017.
 */
@WebServlet(name = "StudentLoginServlet", urlPatterns = "/api/student/login")
public class StudentLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String state = "";
        String action = "student login";
        String msg = "";
        try {
            if (id == null || password == null) {
                state = "1";
                msg = "parameter[id, password] is required";
            } else {
                StudentDao dao = new StudentDao();

                List<Student> students = dao.query("id=? and password=?", new String[]{id, password});
                if (students.size() > 0) {
                    state = "0";
                    msg = "login success";
                } else {
                    state = "1";
                    msg = "login failed";
                }
            }
            JSONObject object = new JSONObject();
            object.put("state", state);
            object.put("action", action);
            object.put("msg", msg);
            PrintWriter writer = response.getWriter();
            writer.write(object.toString());
            writer.flush();
            writer.close();
        } catch (JSONException e) {
            e.printStackTrace();
            response.sendError(500, e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            JSONObject obj = new JSONObject();
            obj.put("state", "1");
            obj.put("action", "student login");
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
