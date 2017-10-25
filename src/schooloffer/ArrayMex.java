package schooloffer;

import java.util.Arrays;

/**
 * Created by caoxiaohong on 17/9/29.
 * 请设计一个高效算法，查找数组中未出现的最小正整数。
 * 给定一个整数数组A和数组的大小n，请返回数组中未出现的最小正整数。保证数组大小小于等于500。
 */
public class ArrayMex {
    public int findArrayMex(int[] A, int n) {
        // write code here
        Arrays.sort(A);
        //找到第一个正数
        int i=0;
        while (A[i]<0 && i<n)
            i++;
        if(i==n || (i<n && A[i]>1))
            return 1;
        //从i开始查找
        for(;i<n-1;i++){
            if(A[i+1]-A[i]>1)
                return A[i]+1;
        }
        return A[n-1]+1;
    }

    public static void main(String[] args) {
        ArrayMex t=new ArrayMex();
        int[] a={-1,2,3,4};
        System.out.println(t.findArrayMex(a,4));
    }
}
