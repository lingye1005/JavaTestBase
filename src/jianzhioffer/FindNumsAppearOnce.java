package jianzhioffer;

import java.util.Arrays;

/**
 * Created by caoxiaohong on 17/8/31.
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * num1,num2分别为长度为1的数组。传出参数
 * 将num1[0],num2[0]设置为返回结果
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Arrays.sort(array);
        int len=array.length;//>=2的一个数字
        int rank=0;
        for(int i=0;i<len;){
            if(i==0){
                if(array[i]!=array[i+1]){
                    num1[0]=array[i];
                    rank+=1;
                    i+=1;
                    continue;
                }else{
                    i+=2;
                    continue;
                }
            }else if(i==len-1){
                if(array[i]!=array[i-1]){
                    num2[0]=array[i];
                    rank+=1;
                    i+=1;
                    continue;
                }else{
                    i+=1;
                    continue;
                }
            }
            else{
                if(array[i]==array[i+1]){
                    i+=2;
                    continue;
                }else{
                    if(rank==0){
                        num1[0]=array[i];
                        i+=1;
                        rank+=1;
                        continue;
                    }else{
                        num2[0]=array[i];
                        i+=1;
                        rank+=1;
                        continue;
                    }
                }
            }
        }
    }
}
