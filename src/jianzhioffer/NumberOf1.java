package jianzhioffer;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/8/25.
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
 */
public class NumberOf1 {
    public int NumberOf1(int n) {
        int count;
        if(n>=0){
            count=0;
            while(n!=0){
                if(n%2==1)
                    count++;
                n=n/2;
            }
            return count;
        }else{
            count=1;
            ArrayList<Integer> list=new ArrayList<Integer>();//0~n位依次存储:从低位到高位的余数
            n=0-n;//将n改为正数
            while(n!=0){
                list.add(n%2);
                n=n/2;
            }
            //因为整数表示是32位01串,所以,如果list长度不足31位,则需要补齐高位为0
            while(list.size()<31){
                list.add(0);
            }
            //因为是负数,所以之前得到的是原码,现在要改为补码,才能求1的个数
            boolean isFind1=false;
            for(int i:list){
                if(isFind1){
                    if(i==0)
                        count++;
                    continue;
                }
                if(!isFind1){
                    if(i==1)
                        count++;
                }
                if(i==1 && !isFind1){
                    isFind1=true;
                    continue;
                }
            }
            return count;
        }
    }


    public static void main(String[] args) {
        NumberOf1 test=new NumberOf1();
        System.out.println(test.NumberOf1(-1));
    }
}
