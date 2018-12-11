package 加密;

import java.security.Provider;
import java.security.Security;

/**
 * @author Isen
 * @date 2018/12/11 19:55
 * @since 1.0
 */
public class Test {

    public static void main(String[] args) {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        for(Provider provider : Security.getProviders()){
            System.out.println(provider.getName());
        }
    }
}
