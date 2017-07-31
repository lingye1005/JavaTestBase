package innerclasses;

/**
 * Created by caoxiaohong on 17/1/18.
 * 闭包与回调
 */

interface Incrementable{
    void increment();
}
//very simple to just implement the interface
class Callee1 implements Incrementable{
    private int i=0;
    public void increment(){
        i++;
        System.out.println(i);
    }
}
class MyIncrement{
    public void increment(){
        System.out.println("Other operation");
    }
    static void f(MyIncrement m){
        m.increment();//调用此类中的方法
    }
}
class Callee2 extends MyIncrement{
    private int i=0;
    public void increment(){
        super.increment();
        i++;
        System.out.println(i);
    }
    private class Closure  implements  Incrementable{
        public void increment(){
            Callee2.this.increment();//注意this此处用法;
        }
    }
    Incrementable getCallbackReference(){//回调函数
        return new Closure();
    }
}
//注意此方式,不是太会的地方;
class Caller{
    private Incrementable callbackReference;
    Caller(Incrementable incrementable){
        callbackReference=incrementable;
    }
    void go(){
        callbackReference.increment();
    }
}
public class Callbacks {
    public static void main(String[] args) {
        Callee1 callee1=new Callee1();
        Callee2 callee2=new Callee2();
        MyIncrement.f(callee2);
        Caller caller1=new Caller(callee1);
        Caller caller2=new Caller(callee2.getCallbackReference());
        caller1.go();
        caller2.go();
    }
}
