package 代理.javassist;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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

/**
 * @author Isen
 * @date 2019/1/25 16:20
 * @since 1.0
 */
public class GenerateCode {

    public static void main(String[] args)
            throws NoSuchMethodException, IllegalAccessException, IOException, InstantiationException, CannotCompileException, NotFoundException, InvocationTargetException {
        dynGenerateClass();

        modifyMethod();
    }

    /**
     * 动态创建一个类
     */
    public static void dynGenerateClass() {
        ClassPool pool = ClassPool.getDefault();
        CtClass ct = pool.makeClass("com.isen.GenerateClass");//创建类
        ct.setInterfaces(new CtClass[]{pool.makeInterface("java.lang.Cloneable")});//让类实现Cloneable接口
        try {
            CtField f = new CtField(CtClass.intType, "id", ct);//获得一个类型为int，名称为id的字段
            f.setModifiers(AccessFlag.PUBLIC);//将字段设置为public
            ct.addField(f);//将字段设置到类上
            //添加构造函数
            CtConstructor constructor = CtNewConstructor
                    .make("public GeneratedClass(int pId){this.id=pId;}", ct);
            ct.addConstructor(constructor);
            //添加方法
            CtMethod helloM = CtNewMethod
                    .make("public void hello(String des){ System.out.println(des);}", ct);
            ct.addMethod(helloM);

//            ct.writeFile();//将生成的.class文件保存到磁盘

            //下面的代码为验证代码
            Field[] fields = ct.toClass().getFields();
            System.out.println("属性名称：" + fields[0].getName() + "  属性类型：" + fields[0].getType());
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
//        catch (IOException e) {
//            e.printStackTrace();
//        } catch (NotFoundException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * 修改Point类的方法
     */
    public static void modifyMethod()
            throws NotFoundException, CannotCompileException, IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ClassPool pool = ClassPool.getDefault();
        CtClass ct = pool.getCtClass("代理.javassist.Point");
        CtMethod m = ct.getDeclaredMethod("move");
        m.insertBefore("{ System.out.print(\"dx:\"+$1); System.out.println(\"dy:\"+$2);}");
        m.insertAfter("{System.out.println(this.x); System.out.println(this.y);}");

//        ct.writeFile();
        //通过反射调用方法，查看结果
        Class pc = ct.toClass();
        Method move = pc.getMethod("move", new Class[]{int.class, int.class});
        Constructor<?> con = pc.getConstructor(new Class[]{int.class, int.class});
        move.invoke(con.newInstance(1, 2), 1, 2);
    }

}
