package exercise15;

import exercise12.util.PoorMansCloneTest;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class ToStringer {
    private ToStringer(){}

    public static String dump(Object obj){
        ArrayList<ObjectWrapper> list = toListOfWrappers(obj.getClass().getDeclaredFields());
        Collections.sort(list);
        return list.stream().map(ObjectWrapper::getFieldName).collect(Collectors.joining("\n"));
    }

    private static ArrayList<ObjectWrapper> toListOfWrappers(Field[] fields){
        ArrayList<ObjectWrapper> list = new ArrayList<>();
        for (Field field: fields) {
            if(field.isAnnotationPresent(Dump.class)){
                list.add(new ObjectWrapper(field));
            }

        }
        return list;
    }
    private static class ObjectWrapper implements Comparable<ObjectWrapper>{
        Field field;
        int order;
        private ObjectWrapper(Field field){
            this.field = field;
            this.order = field.getAnnotation(Dump.class).order();
        }

        public int getOrder() {
            return order;
        }

        public String getFieldName(){
            return field.getName();
        }

        @Override
        public int compareTo(ObjectWrapper o) {

            if(order < o.getOrder()) return -1;
            if(order == o.getOrder()) return 0;
            return 1;
        }
    }



}
