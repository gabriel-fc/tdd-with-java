package exercise12;

import exercise12.security.Q4Proxy;
import exercise12.util.ObjectDumper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q4Test {


    @Test
    public void q4Test(){
        Q4Interface factoryObj = Q4ClassFactory.createQ4Object();
        assertEquals(2.5, factoryObj.methodDouble(), 0.05);
        assertEquals(1, factoryObj.methodInt());
        assertEquals(ObjectDumper.dump(new Q4Class()), factoryObj.toString());
    }
}
