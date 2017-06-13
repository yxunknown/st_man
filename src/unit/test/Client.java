package unit.test;

import dao.StudentDao;

/**
 * Created by mevur on 6/12/2017.
 */
public class Client {
    public static void main(String[] args) {
        StudentDao dao = new StudentDao();
        dao.load("id=? and name=? and password=?", new String[]{"18996486935", "程飘", "loveyx.123"});

    }
}
