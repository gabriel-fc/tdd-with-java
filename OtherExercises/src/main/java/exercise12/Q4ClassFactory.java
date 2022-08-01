package exercise12;

import exercise12.security.Q4Proxy;

public class Q4ClassFactory {
    private Q4ClassFactory(){}

    public static Q4Interface createQ4Object(){
        return new Q4Proxy();
    }
}
