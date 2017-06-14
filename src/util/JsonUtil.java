package util;

import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by Mevur on 6/13/2017.
 */
public class JsonUtil {
    public static JSONObject beanToJSONOBJ(Object obj) {
        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getName());
        }
        return null;
    }
}
