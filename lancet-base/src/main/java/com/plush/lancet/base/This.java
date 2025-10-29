package com.plush.lancet.base;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/23
 * Email: lijt@eetrust.com
 */
public class This {
    public static final String CLASS_NAME = This.class.getName().replace('.', '/');

    public static Object get() {
        return new Object();
    }

    public static Object getField(String fieldName) {
        return new Object();
    }

    public static void putField(Object field, String fieldName) {
    }
}
