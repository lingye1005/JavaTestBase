package jianzhioffer2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: cxh
 * @CreateTime: 18/3/25 21:55
 * @ProjectName: JavaBaseTest
 */
public class FindNumsAppearOnce {
    //test
    public static void main(String[] args) {
        FindNumsAppearOnce t=new FindNumsAppearOnce();
        int[] a={4,6,1,1,1,1};
        t.FindNumsAppearOnce(a,new int[1],new int[1]);
    }

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        String tmp=getXorOfArray(array);
        //求tmp最低位的1的索引
        int idx=getIdxOf1(tmp);
        int dist=tmp.length()-idx-1;//记录离最低位的距离
        for(int i=0;i<array.length;i++){
            String str=Integer.toBinaryString(array[i]);
            int len=str.length();
            if(len>dist && str.charAt(len-dist-1)=='1'){
                list1.add(array[i]);
            }else{
                list2.add(array[i]);
            }
        }
        //分别对list1，list2做异或，求出来的值，就是结果值
        num1[0]=Integer.valueOf(getXorOfList(list1));
        num2[0]=Integer.valueOf(getXorOfList(list2));
        //二进制转十进制
        num1[0]=Integer.parseInt(String.valueOf(num1[0]),2);
        num2[0]=Integer.parseInt(String.valueOf(num2[0]),2);

        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
    //对数组求异或
    private String getXorOfArray(int[] array){
        int[] clone= Arrays.copyOf(array,array.length);
        for(int i=0;i<clone.length-1;i++){
            clone[i+1]^=clone[i];
        }
        return Integer.toBinaryString(clone[array.length-1]);
    }
    //对list求异或
    private String getXorOfList(ArrayList<Integer> list){
        for(int i=0;i<list.size()-1;i++){
            list.set(i+1,list.get(i)^list.get(i+1));
        }
        return Integer.toBinaryString(list.get(list.size()-1));
    }
    //查找字符串右侧第一个1
    private int getIdxOf1(String str){
        int len=str.length();
        for(int i=len-1;i>=0;i--){
            if(str.charAt(i)=='1')
                return i;
        }
        return -1;
    }


}
