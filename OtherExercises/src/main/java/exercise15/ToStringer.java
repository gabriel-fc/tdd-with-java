package exercise15;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ToStringer {
    private ToStringer(){}

    public static String dump(Object obj){
        StringBuilder builder = new StringBuilder();
        for (Field field:obj.getClass().getDeclaredFields()) {

            if (field.isAnnotationPresent(Dump.class)) {
                builder.append(field.getName());
            }
        }
        for (Method method:obj.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Dump.class)) builder.append(method.getName());
        }
        return builder.toString();
    }
}
