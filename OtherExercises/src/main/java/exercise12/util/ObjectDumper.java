package exercise12.util;

import util.StringUtil;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ObjectDumper {

    private ObjectDumper(){}

    public static String dump(Object o) {
        String objStr = o.getClass().toGenericString() + StringUtil.NEWLINE;
        String  output = "Current Object: " + objStr;
        output += Arrays.stream(o.getClass().getDeclaredFields()).map(el->{
            String elementRepresentation = "  ";
            try{
                if( shouldDump(el.getType().getPackageName()) ) {
                    el.trySetAccessible();
                    elementRepresentation += dump(el.get(o));
                }else{

                    elementRepresentation += el.toGenericString();
                }
            }catch (IllegalAccessException e){}
            return elementRepresentation;
        }).collect(Collectors.joining(StringUtil.NEWLINE)) + StringUtil.NEWLINE;

        return output + "End of Object: " + objStr;
    }

    private static boolean shouldDump(String name){
        return !name.contains("java") &&
                !name.contains("javax");
    }
}
