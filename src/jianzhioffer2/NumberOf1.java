package jianzhioffer2;

import java.util.ArrayList;

/**
 * @Author: cxh
 * @CreateTime: 18/1/24 10:19
 * @ProjectName: JavaBaseTest
 * 面试题10
 * 原码变补码:
 * 从右到左查找第一个1,从这个1以后的(以后的都是高位),除了符号位的其它位:1变0,0变1;
 */
public class NumberOf1{
    public int NumberOf1(int n) {
        /**
         * 这个解法最好
        int res=0;
        while(n!=0){
            n&=(n-1);//这两个数字做与运算,可以消除n的二进制位的最低位1
            res++;
        }
        return res;
         **/
        //整数原码表示,负数补码表示
        int res=0;
       if(n>0){
            //求原码
            while (n!=0){
                if(n%2!=0)
                    res++;
                n>>=1;
            }
        }else if(n<0){
            //求原码
           n=(~n)+1;//n<0时,|n|=|~n|+1;注意这一点
           ArrayList<Integer> list=new ArrayList<>();
           while (n!=0){
               list.add(n%2);
               n/=2;//为什么这里不用<<1位呢,因为是负数,n会原来越大
           }
           while(list.size()<31)
               list.add(0);
           //list先存储二进制低位
           boolean isFind=false;
           for(int i:list){
               if(isFind){
                   if(i==0)
                       res++;
                   continue;
               }else if(i==1){
                   isFind=true;
                   res++;
               }
           }
           //符号位为1,故最后res加上1
           res++;
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOf1 test=new NumberOf1();
        System.out.println(test.NumberOf1(-1));
    }
}
