package util;

import com.sun.istack.internal.NotNull;

/**
 * Created by mevur on 6/12/2017.
 */
public class HQLUtil {
    /**
     *
     * @param object
     * @param selection
     * @param args
     * @return
     */
    public static String hql(@NotNull String object,
                             @NotNull String selection,
                             @NotNull String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("from " + object + " where ");
        sb.append(selection);
        int from = 0;
        for (int i = 0; i < args.length; i++) {
            int index = sb.indexOf("?", from);
            if (index != -1) {
                from = index;
                sb.replace(index, index + 1, args[i]);
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
