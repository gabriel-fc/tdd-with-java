package exercise12.util;

import java.util.Arrays;

public class ObjectDumper {
    private ObjectDumper(){}

    public static String dump(Object o) {
        Arrays.stream(o.getClass().getDeclaredFields()).forEach(
                el -> {
                    System.out.println(el.getDeclaringClass());
                    if(!el.getDeclaringClass().toString().contains("java") &&
                            !el.getDeclaringClass().toString().contains("javax")) {
                        System.out.println("recursive");
                        dump(el.getClass());
                    }
                }
        );

        return null;
    }


    //private static String get
}
