package schooloffer;

import java.util.Arrays;

/**
 * Created by caoxiaohong on 17/9/29.
 * 请设计一个复杂度为O(n)的算法，计算一个未排序数组中排序后相邻元素的最大差值。
 * 给定一个整数数组A和数组的大小n，请返回最大差值。保证数组元素个数大于等于2小于等于500。
 * 算法思想:桶排序
 */
public class MaxDivision {
    public int findMaxDivision(int[] A, int n) {
        // write code here
        //先找出数组中最大和最小的值
        int max=A[n-1]>A[n-2]?A[n-1]:A[n-2];
        int min=A[n-1]<A[n-2]?A[n-1]:A[n-2];
        int count=n-3;
        while (count>=0){
            if(A[count]>max){
                max=A[count];
            }
            if(A[count]<min){
                min=A[count];
            }
            count--;
        }
        int[] buckets;
        if(min>0)
            buckets=new int[max+1];
        else
            buckets=new int[max-min+1];
        Arrays.fill(buckets,0);
        //将A中小于0的数字都加上对应的数字保证大于0
        if(min<0) {
           for(int i=0;i<n;i++){
               A[i]+=0-min;
           }
        }
        for(int i:A){
            buckets[i]++;
        }

        //查找桶之间0个数最多的桶
        int first=0,second=0;
        boolean flag=false;
        int result=0;
        for(int i=0;i<buckets.length;){
            if(buckets[i]!=0 && !flag){
                flag=true;
                first=i;
                i++;
            }else if(buckets[i]!=0 && flag){
                second=i;
                flag=false;
                if(second-first>result)
                    result=second-first;

            }else if(buckets[i]==0 && !flag){
                i++;
                continue;
            }else{
                i++;
                continue;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxDivision t=new MaxDivision();
        int[] a={497,269,91,124,121};
        System.out.println(t.findMaxDivision(a,5));
    }
}
