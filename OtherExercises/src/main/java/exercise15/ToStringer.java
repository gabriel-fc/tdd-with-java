package exercise15;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
        Method[] outputMethods;

        private ObjectWrapper(Field field){
            this.field = field;
            this.order = field.getAnnotation(Dump.class).order();
            this.quote =  field.getAnnotation(Dump.class).quote();
            this.outputMethods = new Method[field.getAnnotation(Dump.class).outputMethods().length];
            try{
                for (int i = 0; i < outputMethods.length; i++) {
                    outputMethods[i] = field.getClass().getMethod(field.
                            getAnnotation(Dump.class).
                            outputMethods()[i]);
                }
            }catch (NoSuchMethodException ignored){}
        }

        public boolean isQuote() {
            return quote;
        }


        public int getOrder() {
            return order;
        }


        public String getFieldName(){

            StringBuilder output = new StringBuilder();
            try{

                for (int i = 0; i < outputMethods.length; i++) {
                    outputMethods[i].setAccessible(true);
                    output.append(outputMethods[i].invoke(field));
                    if(i < outputMethods.length - 1) output.append(" | ");
                }
            }catch (IllegalAccessException | InvocationTargetException | ClassCastException e){
                output.append("");
            }
            return output.toString();
        }

        @Override
        public int compareTo(ObjectWrapper o) {
            return Integer.compare(order, o.getOrder());
        }
    }



}
