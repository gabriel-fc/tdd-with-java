package exercise15;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;


public class ToStringer {
    private ToStringer(){}

    public static String dump(Object obj){
        ArrayList<ObjectWrapper> list = toListOfWrappers(obj.getClass().getDeclaredFields());
        Collections.sort(list);
        return list.stream().map(wrapper->{
            if (wrapper.isQuote()) return '"'+ wrapper.getFieldName() + '"';
            return wrapper.getFieldName();
        }).collect(Collectors.joining("\n"));
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
        boolean quote;
        private ObjectWrapper(Field field){
            this.field = field;
            this.order = field.getAnnotation(Dump.class).order();
            this.quote =  field.getAnnotation(Dump.class).quote();
        }

        public boolean isQuote() {
            return quote;
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
