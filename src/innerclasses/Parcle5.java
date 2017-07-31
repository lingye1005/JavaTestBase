package innerclasses;

import sun.security.krb5.internal.crypto.Des;

/**
 * Created by caoxiaohong on 17/1/15.
 * 局部内部类
 */
public class Parcle5 {
    public  Destination destination(String s){
        //start-class
        class PDestination implements Destination{
            String readLine;
            private PDestination(String whereTo){//构造器实现方法
                readLine=whereTo;
            }
            public String readLabel(){//内部类
                return readLine;
            }
        }
        //end-class
        return new PDestination(s);
    }
    public static void main(String[] args){
        Parcle5 parcle5=new Parcle5();
        Destination destination=parcle5.destination("Tasmania");
    }
}
