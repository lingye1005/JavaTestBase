package Interface;

/**
 * Created by caoxiaohong on 16/12/4.
 */

interface test1{
   public void t11();
    public void t12();
}
interface  test2{
    public void  t21();
    public void  t22();
}
interface   test3{
    public void  t31();
    public void  t32();
}
interface  test4 extends test1,test2,test3{
    public void t41();
}
class  tt{
    void tt1(){
        System.out.println("this is tt tt1()");
    }
}
 abstract class ttt{
    void ttt1(){System.out.println("this is the ttt ttt1()");}
}

class t extends tt implements test4{
    public void t11(){}
    public void t12(){}
    public void t21(){}
    public void t22(){}
    public void t31(){}
    public void t32(){}
    public void t41(){}
}

class tx extends ttt implements test4{
    public void t11(){}
    public void t12(){}
    public void t21(){}
    public void t22(){}
    public void t31(){}
    public void t32(){}
    public void t41(){}
}

public class p181_14 {
}
