package api;

import dao.ExpDao;
import model.Exp;
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
@WebServlet(name = "ExpServlet", urlPatterns = "/api/exp")
public class ExpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String title = request.getParameter("title");
        String teacher = request.getParameter("teacher");
        String content = request.getParameter("content");
        String state;
        String action = "post exp";
        String msg;
        try {
            if (title == null || teacher == null || content == null) {
                state = "0";
                msg = "parameter[title, teacher, content] is required";
            } else {
                ExpDao dao = new ExpDao();
                Exp exp = new Exp();
                exp.setContent(content);
                exp.setTeacher(teacher);
                exp.setContent(content);
                if (dao.save(exp)) {
                    state = "0";
                    msg = "post exp success";
                } else {
                    state = "1";
                    msg = "post exp failed";
                }
            }
            JSONObject obj = new JSONObject();
            obj.put("state", state);
            obj.put("msg", msg);
            obj.put("action", action);
            PrintWriter writer = response.getWriter();
            writer.write(obj.toString());
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
        String id = request.getParameter("id");
        String teacher = request.getParameter("teacher");
        String selection = "";
        if (id != null) {
            selection = "id=" + id;
        } else if (teacher != null) {
            selection = "teacher=" + teacher;
        } else {
            selection = "";
        }


        try {
            JSONObject obj = new JSONObject();
            obj.put("state", "1");
            obj.put("action", "post exp");
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
