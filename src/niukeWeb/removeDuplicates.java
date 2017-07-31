package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/6/24.
 * 给定排序数组A,运行数组中同一个数字最多出现2次,删除多余数字,并返回最终数组中元素的数组个数n
 */
public class removeDuplicates {
    public int removeDuplicates(int[] A) {
        if(A==null ||A.length==0)
            return 0;
        if(A.length==1)
            return 1;
        int count=1;//记录数组中元素个数
        int pre=A[0];
        int tempcount=1;//记录相同节点个数是否到2;
        ArrayList<Integer> list=new ArrayList<Integer>();//存放保存记录
        list.add(A[0]);
        for(int i=1;i<A.length;i++){
            if(A[i]==pre && tempcount<2){
                tempcount++;
                list.add(A[i]);
                count++;
            }else if(A[i]==pre && tempcount>=2){
                continue;
            }else if(A[i]!=pre){
                tempcount=1;
                pre=A[i];
                list.add(A[i]);
                count++;
            }
        }
        //将list中数据导入A中
        int i=0;
        for(int a:list){
            A[i++]=a;
        }
        return count;
    }

    public static void main(String[] args) {
        removeDuplicates test=new removeDuplicates();
        int[] a=new int[6];
        a[0]=1;
        a[1]=1;
        a[2]=1;
        a[3]=2;
        a[4]=2;
        a[5]=3;
        System.out.println(test.removeDuplicates(a));;

    }
}
