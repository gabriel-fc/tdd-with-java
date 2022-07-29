package exercise12.util;

import util.StringUtil;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ObjectDumper {

    private ObjectDumper(){}

    public static String dump(Object o) {
        String objStr = getObjectString(o) + StringUtil.NEWLINE;
        String  output = "Current Object: " + objStr;
        output += Arrays.stream(o.getClass().getDeclaredFields()).map(el->{
            String elementRepresentation = "  ";
            try{
                el.trySetAccessible();
                if( shouldDump(el.getType().getPackageName()) ) {

                    elementRepresentation += dump(el.get(o));
                }else{
                    elementRepresentation += getObjectString(el.get(o));
                }
            }catch (IllegalAccessException e){
                e.printStackTrace();
                System.exit(-1);
            }
            return elementRepresentation;
        }).collect(Collectors.joining(StringUtil.NEWLINE)) + StringUtil.NEWLINE;
        return output + "End of Object: " + objStr;
    }

    private static boolean shouldDump(String name){
        return !name.contains("java") &&
                !name.contains("javax");
    }


    private static String getObjectString(Object o){
        return o.getClass().getPackageName() + " " +
                o.getClass().getTypeName() +  " " +
                o.getClass().getSimpleName();

    }
}
