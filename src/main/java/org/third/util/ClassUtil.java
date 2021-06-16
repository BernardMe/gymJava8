package org.third.util;

public class ClassUtil {

    public static boolean isAssignableFrom(Class aim, Class from) {
        return aim.isAssignableFrom(from);
    }
    
    public static boolean isNumber(Class clazz) {
        return isAssignableFrom(Number.class, clazz) || isInt(clazz) || isLong(clazz) || isDouble(clazz) || isByte(clazz) || isFloat(clazz) || isShort(clazz);
    }

    public static boolean isByte(Class clazz) {
        return clazz == Byte.TYPE || clazz == Byte.class;
    }

    public static boolean isShort(Class clazz) {
        return clazz == Short.TYPE || clazz == Short.class;
    }

    public static boolean isInt(Class clazz) {
        return clazz == Integer.TYPE || clazz == Integer.class;
    }

    public static boolean isLong(Class clazz) {
        return clazz == Long.TYPE || clazz == Long.class;
    }

    public static boolean isDouble(Class clazz) {
        return clazz == Double.TYPE || clazz == Double.class;
    }

    public static boolean isFloat(Class clazz) {
        return clazz == Float.TYPE || clazz == Float.class;
    }
}


