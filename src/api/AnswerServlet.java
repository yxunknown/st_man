package api;

import dao.AnswerDao;
import model.Answer;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.jar.JarException;

/**
 * Created by Mevur on 6/13/2017.
 */
@WebServlet(name = "AnswerServlet", urlPatterns = "/api/answer")
public class AnswerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String student = request.getParameter("student");
        String exp = request.getParameter("exp");
        String content = request.getParameter("content");
        String action = "post answer";
        String state;
        String msg;
        try {
            if (student == null || exp == null || content == null) {
                state = "1";
                msg = "parameter[student, exp, content] is required";
            } else {
                Answer answer = new Answer();
                answer.setExp(exp);
                answer.setContent(content);
                answer.setStudent(student);
                AnswerDao dao = new AnswerDao();
                if (dao.save(answer)) {
                    state = "0";
                    msg = "post answer success";
                } else {
                    state = "1";
                    msg = "post answer failed";
                }
            }
            JSONObject object = new JSONObject();
            object.put("action", action);
            object.put("state", state);
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


        getLastModified()
    }
}
