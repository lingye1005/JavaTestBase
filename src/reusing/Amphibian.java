package reusing;

/**
 * Created by caoxiaohong on 16/11/23.
 * 7.7中的练习17,测试继承中的问题
 */

class Frog{
    public void t1(){}
    void t2(){}
    void t3(){System.out.println("this is base");}
}

public class Amphibian extends Frog {

    @Override
    public void t1(){System.out.println("this is son");}
    @Override
    void t2(){System.out.println("this is son");}

    public static void main(String[] args){
        Amphibian amphibian=new Amphibian();
        amphibian.t1();
        amphibian.t2();
        amphibian.t3();
    }
}
