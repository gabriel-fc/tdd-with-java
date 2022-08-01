package exercise12.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

public class PoormansClone {
    private PoormansClone() {
    }

    public static Object clone(Object obj)
            throws Exception {
        Object clone = obj.getClass().getConstructor().newInstance();
        setFields(obj, clone);
        return clone;

    }

    private static void setFields(Object obj, Object clone)
    throws Exception{
        for (Field field: obj.getClass().getFields()) {
            Field cloneField = clone.getClass().getField(field.getName());
            field.setAccessible(true);
            cloneField.setAccessible(true);
            cloneField.set(clone, field.get(obj));
        }
    }

}
