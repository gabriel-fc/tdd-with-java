package exercise15;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Dump {
    int order () default Integer.MAX_VALUE;
    boolean quote () default false;
    String outputMethod () default "toString";
}
