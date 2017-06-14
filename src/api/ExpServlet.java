package api;

import dao.ExpDao;
import model.Exp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import util.HQLUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.TabExpander;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by mevur on 6/12/2017.
 */
@WebServlet(name = "ExpServlet", urlPatterns = "/api/exp")
public class ExpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String teacher = request.getParameter("teacher");
        String content = request.getParameter("content");
        String state;
        String action = "post exp";
        String msg;
        ExpDao dao = new ExpDao();
        try {
            if (id != null) {
                //更新 exp
                Exp exp = new Exp();
                exp.setId(Integer.parseInt(id));
                if (teacher != null) {
                    exp.setTeacher(teacher);
                }
                if (title != null) {
                    exp.setTitle(title);
                }
                if (content != null) {
                    exp.setContent(content);
                }
                if (dao.update(exp)) {
                    state = "0";
                    msg = "update exp:" + exp.toString() + "is success";
                } else {
                    state = "1";
                    msg = "update exp is failed";
                }
            } else {
                //添加 exp
                if (title == null || teacher == null || content == null) {
                    state = "0";
                    msg = "parameter[title, teacher, content] is required";
                } else {
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
        String selection;
        String[] args;
        try {
            if (id != null) {
                selection = "id=?";
                args = new String[]{id};
            } else if (teacher != null) {
                selection = "teacher=?";
                args = new String[]{teacher};
            } else {
                selection = null;
                args = null;
            }
            ExpDao dao = new ExpDao();
            List<Exp> exps = dao.query(selection, args);
            JSONArray array = new JSONArray();
            for (int a = 0; a < exps.size(); a++) {
                array.put(exps.get(a).toJSON());
            }
            JSONObject obj = new JSONObject();
            obj.put("state", "1");
            obj.put("action", "post exp");
            obj.put("msg", "success");
            obj.put("data", array);
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
