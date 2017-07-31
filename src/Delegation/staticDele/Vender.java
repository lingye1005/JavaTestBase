package Delegation.staticDele;

/**
 * Created by caoxiaohong on 17/3/26.
 * 委托方实现接口方法
 */
public class Vender implements Sell{
    @Override
    public void sell(){
        System.out.println("in sell  method");
    }
    @Override
    public void add(){
        System.out.println("in add  method");
    }
}
