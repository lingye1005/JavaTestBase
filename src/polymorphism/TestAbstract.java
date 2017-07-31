package polymorphism;

/**
 * Created by caoxiaohong on 16/11/28.
 * page 171 practice
 */

 /*abstract class t1{
    t1(){
        h1();
    }
    abstract void h1();
}
class t2 extends  t1{
    int testnum=1;
    @Override
    void h1(){
        System.out.println("this is t2 h1() and testnum is "+testnum);
}
}*/

/*abstract class te{}
class te1 extends  te{
    void test(){}
}*/


public class TestAbstract {
    public static String s="this is a split test";
    public static void main(String[] args){

      System.out.println(s.split(""));
    }
}
