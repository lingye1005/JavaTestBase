package innerclasses;

import sun.jvm.hotspot.memory.SymbolTable;
import sun.security.krb5.internal.crypto.Des;

import javax.xml.soap.SOAPPart;

/**
 * Created by caoxiaohong on 16/12/20.
 * 10.4 内部类与向上转型 p194
 * 将内部类向上转型为其基类,尤其是转型为一个接口的时候,内部类就有了用武之地.
 */
//2个接口,表示客户端可用的两个接口
 interface Destination1{
    String readLabel();
}
interface Contents1{
    int value();
}

class TestParcel{
    private class PContents implements Contents1{
        private int i=11;
        public int value(){
            return i;
        }
    }
    protected class PDestination implements Destination1{
        private String label;
        private PDestination(String s){this.label=s;}
        public String readLabel(){
            return label;
        }
    }
    public Destination1 destination(String s){
        return new PDestination(s);
    }
    public Contents1 contents(){
        return  new PContents();
        //this.contents();
    }
}

public class Parcel4 {
    public static void main(String[] args){
        TestParcel testParcel=new TestParcel();
        Contents1 contents=testParcel.contents();

        /*boolean res= testParcel instanceof TestParcel;
        System.out.println(res);*/
        /*int i=-10;
        int temp1=i>>2,temp2=i<<2,temp3=i>>>2;
        System.out.println(temp1+" "+temp2+" "+temp3);*/
        /*int[] temp=new int[5];
        //temp={1,2,3,4,5};初始化位置错误;只能在初始化时这样做;
        int[] te={1,2,3,4,3};//如此初始化才可以;*/

        Destination1 destination=testParcel.destination("this is a test");

    }
}
