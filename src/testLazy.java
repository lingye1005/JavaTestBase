/**
 * Created by caoxiaohong on 16/11/8.
 */
class Simple{
    String s;
    public Simple(String si){s=si;}//构造函数,内部为构造变量赋值
    public String toString(){return s;}//复写
    public void setString(String sstr){s=sstr;}//普通函数
}

class Second{
    Simple simple;
    String s;
    public Second (String si){s=si;}//构造函数,内部为变量赋值

    public void check()//单纯检测simple是否已经创建.
    {
        if(simple==null)
            System.out.println("simple is not initlized");
        else
            System.out.println("simple is initlized");
    }
    private Simple lazy()//检测simple是否已经创建,如果没有创建就创建一个
    {
        if(simple==null){
            System.out.println("simple is creating");
            simple=new Simple(s);
        }
        return simple;
    }
    public Simple getSimple() //获取simple的值
    {
        return lazy();
    }
    public void setSimple(String sNew) //设定simple的值
    {
        lazy().setString(sNew);
    }
    public  String toString()   //复写tosring()方法,输出
    {
        return lazy().toString();
    }
}

public class testLazy {
    public static void main(String[] args)
    {
        Second second=new Second("intit String");
        second.check();
        //输出:simple is not initlized
        //同时为second类中的变量s赋值为:s="intit String"
        System.out.println(second.getSimple());
        //创建simple,为simple赋值:simple="intit String"
        //输出:simple is creating
        //    intit String
        second.check();
        //输出:simple is initlized
        second.setSimple("New String");
        //输出:intit String
        System.out.println(second);
        //输出:New String
    }
}
