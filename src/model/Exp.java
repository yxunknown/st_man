package model;

import org.json.JSONException;
import org.json.JSONObject;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by mevur on 6/11/2017.
 */
@Entity
public class Exp {
    private int id;
    private String teacher;
    private String title;
    private String content;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "teacher", nullable = false, length = -1)
    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Basic
    @Column(name = "title", nullable = false, length = -1)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content", nullable = false, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject object = new JSONObject();
        object.put("id", id);
        object.put("teacher", teacher);
        object.put("title", title);
        object.put("content", content);
        return object;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exp exp = (Exp) o;

        if (id != exp.id) return false;
        if (teacher != null ? !teacher.equals(exp.teacher) : exp.teacher != null) return false;
        if (title != null ? !title.equals(exp.title) : exp.title != null) return false;
        if (content != null ? !content.equals(exp.content) : exp.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        try {
            return toJSON().toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return super.toString();
        }
    }
}
