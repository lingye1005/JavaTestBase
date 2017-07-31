package reusing;

import java.text.DecimalFormat;

import access.Cake;


/**
 * Created by caoxiaohong on 16/11/21.
 */

 class test11 extends Cake{

    protected  void testPackageProtected(){}

}

class h1{
    h1(int i){
        System.out.println("this is h1 cons...");
    }
    void t1(){
        System.out.println("this is t1");
    }
    void t2(char ch){
        System.out.println("this is t2");
    }
}
class  h2 extends  h1{

    h2(int i){
        super(i);
        System.out.println("this is h2 cons...");
    }
    @Override
    void t1(){
        System.out.println("this is h2 t1");
    }
    @Override
    void t2(char h){
        System.out.println("this is h2 t2"+" and this is "+h);
    }
}


public class OverrideTest {
    public static void main(String[] args){
       /* h2 test=new h2(1);
        test.t1();
        test.t2('c');*/
       /* int temp[][]=new int[3][];//第一个高维必须初始化数字
        temp[0]=new int[3];
        temp[1]=new int[1];
        temp[2]=new int[2];
        temp[0][0]=10;
        temp[0][1]=11;
        temp[0][2]=12;
        temp[1][0]=20;
        temp[2][0]=30;
        temp[2][1]=31;
        for(int i=0;i<temp.length;i++)
        {
            for(int j=0;j<temp[i].length;j++)
                System.out.println(temp[i][j]);
        }*/
        /*//静态数组定义
        int[][] temp={{1,2},{3,4,5},{6,7,8,9}};
        for(int i=0;i<temp.length;i++)
        {
            for(int j=0;j<temp[i].length;j++){
                System.out.println(temp[i][j]);
            }
        }*/
        DecimalFormat df1=new DecimalFormat("00.00%");
        DecimalFormat df3=new DecimalFormat("00.00");

        DecimalFormat df2=new DecimalFormat("##.##%");
        DecimalFormat df4=new DecimalFormat("##.##");

        System.out.println(df1.format(0.23));
        System.out.println(df3.format(0.23));

        System.out.println(df2.format(0.23));
        System.out.println(df4.format(0.23));

        test11 hh=new test11();
        hh.testPackagePublic();
        hh.testPackageProtected();
    }
}
