package innerclasses;

/**
 * Created by caoxiaohong on 16/12/17.
 */
public class Outer {
    //内部类方法:返回内部类
     class Inner{
        Inner(String s){System.out.println("this is Inner _"+s);}
       public void printlist(){System.out.println("this is Inner printlist()");}
    }
    public  Inner getInnerClass(String s){
        return new Inner(s);
    }
    public static void main(String[] args){
        Outer outer=new Outer();
        Outer.Inner inner=outer.getInnerClass("cxh");
        inner.printlist();
    }
}
