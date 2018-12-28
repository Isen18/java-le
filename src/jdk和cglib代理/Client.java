package jdk和cglib代理;

import org.junit.Test;

public class Client {

    @Test
    public void testCGLibProxy() {
        //代理接口测试
        UserManager userManager = new CGLibProxy().newProxy(UserManager.class);
        userManager.addUser("1", "123");
        userManager.delUser("1");

        //代理接口实现类测试
        UserManager userManager2 = (UserManager) new CGLibProxy().newProxy(new UserManagerImpl());
        userManager2.addUser("1", "123");
        userManager2.delUser("1");

        //代理接口实现类测试
        UserManagerImpl2 userManagerImpl2 = (UserManagerImpl2) new CGLibProxy().newProxy(new UserManagerImpl2());
        userManagerImpl2.addUser("1", "123");
        userManagerImpl2.delUser("1");
    }

    @Test
    public void testJdkProxy(){
        //代理接口测试
        UserManager userManager = new JDKProxy().newProxy(UserManager.class);
        userManager.addUser("1", "123");
        userManager.delUser("1");

        //代理接口实现类测试
        UserManager userManager2 = (UserManager) new JDKProxy().newProxy(new UserManagerImpl());
        userManager2.addUser("1", "123");
        userManager2.delUser("1");
    }
}
