package Delegation.dynamicDele;

/**
 * Created by caoxiaohong on 17/3/26.
 * 委托方,供应商
 */
public class Vender implements Sell {
    public void sell(){
        System.out.println("this is sell method");
    }
    public void add(){
        System.out.println("this is add method");
    }
}
