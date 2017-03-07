import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by buptcszh on 2017/3/7.
 */
public class DynamicProxy {

    public static void main(String[] args) {

        Cls c = new Cls();  // 委托类
        InvocationHandler handler = new MyInvocationHandler(c);  // InvocationHandler

        Itf proxy = (Itf) Proxy.newProxyInstance(
                Cls.class.getClassLoader(),  // 用来加载代理类的ClassLoader
                new Class[] {Itf.class},     // 委托类实现的接口们,表示需要拦截的方法
                handler                      // 与代理类相关联的InvocationHandler
        );  // 运行时动态地创建代理类

        proxy.printMe();
    }
}

// 委托类必须实现接口
interface Itf {

    void printMe();

    void printSth(String me);
}

// 委托类
class Cls implements Itf {

    @Override
    public void printMe() {
        System.out.println("I'm Cls");
    }

    @Override
    public void printSth(String me) {
        System.out.println(me);
    }
}

// 代理类的方法调用会交给InvocationHandler的invoke方法
class MyInvocationHandler implements InvocationHandler {

    // obj是委托类
    private Object obj;

    public MyInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    // proxy是代理类,但一般用不到这个参数
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before");
        Object result = method.invoke(obj, args);
        System.out.println("after");
        return result;
    }
}