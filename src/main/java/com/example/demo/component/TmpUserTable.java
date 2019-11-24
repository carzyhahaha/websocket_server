package com.example.demo.component;
import java.util.LinkedHashMap;
import java.util.Map;

public class TmpUserTable {

    public static final Map<String, String> USER_MAP = new LinkedHashMap<>();

    static {
        USER_MAP.put("admin", "admin");
        USER_MAP.put("test", "test");
        USER_MAP.put("xiaoming", "xiaoming");
    }

    public static String getUserInfo(String username) {
        return USER_MAP.get(username);
    }
}
