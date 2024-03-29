package 代理;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * CGLibProxy动态代理，可以代理接口或者类
 */
public class CGLibProxy implements MethodInterceptor {

    /**
     * CGLib需要代理的目标对象
     */
    private Object targetObject;

    /**
     * 为接口生成代理对象
     * @param clazz 被代理类
     * @return 代理对象
     */
    @SuppressWarnings("unchecked")
    public <T> T newProxy(Class<T> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return (T)enhancer.create();
    }

    /**
     * 为类生成代理对象
     * @param object 被代理的对象
     * @return 代理对象
     */
    public Object newProxy(Object object) {
        this.targetObject = object;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     * @param proxy 要进行增强的对象
     * @param method 拦截的方法
     * @param args 参数列表
     * @param methodProxy 表示对方法的代理 invokeSuper方法表示对被代理对象方法的调用
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if(targetObject != null){
            //代理类
            System.out.println("调用被代理对象的方法开始");
            Object result = method.invoke(targetObject, args);
            System.out.println("调用被代理对象的方法结束");
            return result;
        }else {
            //代理接口
            System.out.println("方法调用开始");
            System.out.println("此处编写接口的实现代码");
            System.out.println("method toGenericString:" + method.toGenericString());
            System.out.println("method name:" + method.getName());
            System.out.println("method args:" + args.length);
            System.out.println("方法调用结束");
            return "方法调用结果";
        }
    }
}
