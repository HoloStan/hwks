package me.holostan.hk.framework.utils.string;

import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lxu on 6/29/2016.
 */
public class RegexUtil {
    private static Logger logger = Logger.getLogger(RegexUtil.class);

    public static boolean check(String reg, String string) {
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(string);

        return matcher.matches();
    }

    public static String getGroup(String reg, String text, int num) {
        Pattern pattern = Pattern.compile(reg, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);
        if (matcher.matches()) {
            return matcher.group(num);
        }
        return "";
    }
}
