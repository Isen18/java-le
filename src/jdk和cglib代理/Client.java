package jdk和cglib代理;

public class Client {

    public static void main(String[] args) {

        UserManager userManager = (UserManager) new CGLibProxy().createProxyObject(new UserManagerImpl());
        System.out.println("-----------CGLibProxy-------------");
        userManager.addUser("tom", "root");

        System.out.println("-----------JDKProxy-------------");
        JDKProxy jdkProxy = new JDKProxy();
        UserManager userManagerJDK = (UserManager) jdkProxy.newProxy(new UserManagerImpl());
        userManagerJDK.addUser("tom", "root");
    }


}
