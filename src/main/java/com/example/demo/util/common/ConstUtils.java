package com.example.demo.util.common;


import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;


public class ConstUtils {

    public static String getValue(String fieldName, Class<?> clazz) {

        Field[] fields = clazz.getFields();

        return null;
    }

    public static Map<Object, String> getConstValueMap(Class<?> clazz) {
        Map<Object, String> rs = new LinkedHashMap<>();

        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            field.getAnnotatedType();

        }
        return rs;
    }
}
