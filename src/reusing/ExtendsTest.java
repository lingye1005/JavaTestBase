package reusing;

/**
 * Created by caoxiaohong on 16/11/19.
 * 7.2继承语法,练习题5
 */


class A{
    A(int i){System.out.println("this is a constA..");}
}
class B{}
class C extends A{
    C(int i){
        super(i);
        System.out.println("this is a constC...");
    }

    public void cExample() {
        B b=new B();
    }
}
//7.2 练习题8
class t1{
    t1(int i){
        System.out.println("this is t1 constructor");
    }
}
class t2 extends t1{
    t2(int i){
        super(i);
    }
    t2(){super(1);}
}
//7.2 练习题8
public class ExtendsTest {
    public  static void main(String[] args){
        C c=new C(11);
    }
}
