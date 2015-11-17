package jp.co.pekanazawa.common.util;

public class UrlUtil {
    private static final String REDIRECT_TO = "redirect:";

    public static String redirectTo(String path) {
        StringBuilder sb = new StringBuilder();
        sb.append(REDIRECT_TO);
        sb.append(path);
        return sb.toString();
    }
}
