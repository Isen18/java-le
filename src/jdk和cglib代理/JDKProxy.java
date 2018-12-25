package jdk和cglib代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理类
 */
public class JDKProxy implements InvocationHandler {

    /**
     * 需要代理的目标对象
     */
    private Object targetObject;

    /**
     * 为目标对象生成代理对象
     */
    public Object newProxy(Object targetObject) {
        this.targetObject = targetObject;
        //返回代理对象
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }    
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        //模拟检查权限
        checkPopedom();
        return method.invoke(targetObject, args);
    }    
    
    private void checkPopedom() {
        System.out.println("检查权限  checkPopedom()!");
    }    
}    
