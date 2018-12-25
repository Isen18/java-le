package jdk和cglib代理;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * CGLibProxy动态代理类的实例
 */
public class CGLibProxy implements MethodInterceptor {

    /**
     * CGLib需要代理的目标对象
     */
    private Object targetObject;

    public Object createProxyObject(Object obj) {
        this.targetObject = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        // 返回代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if ("addUser".equals(method.getName())) {
            // 过滤方法
            checkPopedom();
        }
        return method.invoke(targetObject, args);
    }

    private void checkPopedom() {
        System.out.println("检查权限  checkPopedom()!");
    }
}    
