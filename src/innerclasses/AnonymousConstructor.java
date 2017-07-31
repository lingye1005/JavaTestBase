package innerclasses;

/**
 * Created by caoxiaohong on 17/1/15.
 * 10.6匿名内部类
 */
abstract class Base{
    public Base(int i){
        System.out.println();
    }
    public abstract void f();
}
public class AnonymousConstructor {
    public static Base getBase(int i){
        return new Base(i){
            {System.out.println("inside instance initiallizer");}
            public void f(){
                System.out.println("in anonymous`s f()");
            }
            //int h=i+1; i应该被定义为final,因为在匿名内部类中被使用.
        };
    }
    public static void main(String[] args){
        Base base=getBase(10);
        base.f();
    }
}
