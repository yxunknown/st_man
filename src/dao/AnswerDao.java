package dao;

import model.Answer;
import util.HQLUtil;

import java.util.List;

/**
 * Created by mevur on 6/12/2017.
 */
public class AnswerDao extends Dao{
    public boolean save(Answer answer) {
        return super.insert(answer);
    }
    public boolean update(Answer answer) {
        return super.update(answer);
    }
    public boolean delete(Answer answer) {
        return super.delete(answer);
    }
    public List<Answer> query(String selection, String[] args) {
        String hql = HQLUtil.hql("Answer", selection, args);
        List<Answer> answers = super.query(hql);
        return answers;
    }
}
