package jdk和cglib代理;

/**
 * 语法：
 * [返回值类型] 通知函数名称(参数) [returning/throwing 表达式]：连接点函数(切点函数){
 *      函数体
 * }
 *
 * @author Isen
 * @date 2019/1/2 20:26
 * @since 1.0
 */
public aspect AspectDemo {
    /**
     * 日志记录切点
     */
    pointcut recordLog():call(* HelloWord.sayHello(..));

    /**
     * 权限验证切点
     */
    pointcut authCheck():call(* HelloWord.sayHello(..));

    pointcut incPointCut():call(* HelloWord.inc(..));

    pointcut funPointCut():call(* HelloWord.fun(..));

    /**
     * 前置通知!
     */
    before():authCheck(){
        System.out.println("sayHello方法执行前验证权限");
    }

    /**
     * 后置通知
     */
    after():recordLog(){
        System.out.println("sayHello方法执行后记录日志");
    }

    /**
     * 带有返回值的后置通知
     * 返回值类型为int
     */
    after() returning(int ret): incPointCut(){
        System.out.println(" ret=" + ret);
    }

    /**
     * 异常通知
     */
    after() throwing(Exception e):funPointCut(){
        System.out.println("抛出异常:" + e.toString());
    }

    /**
     * 定义环绕通知
     */
    Object around():incPointCut(){
        System.out.println("sayAround 执行前执行");
        //执行目标函数
        Object result = proceed();
        System.out.println("sayAround 执行后执行");
        return result;
    }
}
