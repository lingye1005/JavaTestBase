/**
 * created by cxh on 17/7/27
 */

class Base{
    //静态语句块
    static{
        System.out.println("执行基类的静态语句块!");
    }
    //构造器方法
    Base(){
        System.out.println("执行基类的构造器方法!");
    }
    //构造器代码块
    {
        System.out.println("执行基类的构造代码块!");
    }
}
public class TempTest extends Base {
    //静态语句块
    static{
        System.out.println("执行子类的静态语句块!");
    }
    //构造器方法
    TempTest(){
        System.out.println("执行子类的构造器方法!");
    }
    //构造器代码块
    {
        System.out.println("执行子类的构造代码块!");
    }
    public static void main(String[] args){
        TempTest a=new TempTest();
        System.out.println("----------------");
        TempTest b=new TempTest();
    }
}



