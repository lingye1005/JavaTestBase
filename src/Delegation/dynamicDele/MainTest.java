package Delegation.dynamicDele;

import java.lang.reflect.Proxy;

/**
 * Created by caoxiaohong on 17/3/26.
 */
public class MainTest {
    public static void main(String[] args) {
        //创建中介类实类
        DynamicProxy dynamicProxy=new DynamicProxy(new Vender());

        //获取代理类实例sell
        //在下代码中，我们调用Proxy类的newProxyInstance方法来获取一个代理类实例。
        //          这个代理类实现了我们指定的接口并且会把方法调用分发到指定的调用处理器。
        Sell sell=(Sell)(Proxy.newProxyInstance(Sell.class.getClassLoader(),new Class[]{Sell.class}, dynamicProxy));
        sell.add();
        sell.sell();
    }
}
