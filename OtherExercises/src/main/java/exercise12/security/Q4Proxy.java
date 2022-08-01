package exercise12.security;

import exercise12.Q4Class;
import exercise12.Q4Interface;
import exercise12.util.ObjectDumper;

public class Q4Proxy implements Q4Interface {
    private Q4Interface obj;
    public Q4Proxy(){
        this.obj = new Q4Class();
    }

    @Override
    public int methodInt() {
        return obj.methodInt();
    }

    @Override
    public Double methodDouble() {
        return obj.methodDouble();
    }

    @Override
    public String toString() {
        return ObjectDumper.dump(obj);
    }
}
