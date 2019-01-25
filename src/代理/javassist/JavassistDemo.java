package 代理.javassist;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewConstructor;
import javassist.CtNewMethod;
import javassist.NotFoundException;
import javassist.bytecode.AccessFlag;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import 代理.Say;

/**
 * @author Isen
 * @date 2019/1/25 10:33
 * @since 1.0
 */
public class JavassistDemo {

    public static void main(String[] args) throws Exception {
        testJavassistFactoryProxy();
        testJavassistDefineClass();
    }

    // 代理工厂创建动态代理
    public static void testJavassistFactoryProxy() throws Exception {
        // 创建代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();

        // 设置被代理类的类型
        proxyFactory.setSuperclass(Say.class);

        // 创建代理类的class
        Class<?> proxyClass = proxyFactory.createClass();

        // 创建对象
        Say proxyTest = (Say) proxyClass.newInstance();

        ((ProxyObject) proxyTest).setHandler(new MethodHandler() {
            Say test = new Say();

            @Override
            public Object invoke(Object self, Method thisMethod,
                    Method method1, Object[] args) throws Throwable {
                String before = "before ";
                Object str = thisMethod.invoke(test, args);
                String after = " after";
                return before + str + after;
            }

        });
        System.out.println(proxyTest.say("world"));
    }

    // 动态代码创建的例子
    // 下面例子使用 Javassist 的 API成功组织出代理类的一个子类，可以看出 添加构造函数，添加属性，
    // 添加方法，内容 都是通过字符串类型完成即可。 通过 Javassist 强大的字节生成能力可以达到动态
    // 增加类和实现动态代理的功能.
    public static void testJavassistDefineClass() throws Exception {
        // 创建类池，true 表示使用默认路径
        ClassPool classPool = new ClassPool(true);

        String className = Say.class.getName();
        // 创建一个类 SayJavassistProxy
        CtClass ctClass = classPool.makeClass(className + "JavassistProxy");

        // 添加超类
        // 设置 SayJavassistProxy 的父类是 Say.
        ctClass.setSuperclass(classPool.get(Say.class.getName()));

        // 添加默认构造函数
        ctClass.addConstructor(CtNewConstructor.defaultConstructor(ctClass));

        // 添加属性
        ctClass.addField(CtField.make("public " + className + " real = new " +
                className + "();", ctClass));

        // 添加方法，里面进行动态代理 logic
        ctClass.addMethod(CtNewMethod
                .make("public String test() { return \"before \" + real.test() + \" after\";}",
                        ctClass));
        Class<?> testClass = ctClass.toClass();
        Say proxyTest = (Say) testClass.newInstance();
        System.out.println(proxyTest.test());
    }
}
