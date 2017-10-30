package schooloffer16;

import java.util.Arrays;

/**
 * Created by caoxiaohong on 17/9/25.
 * 给定两个有序数组arr1和arr2，在给定一个整数k，返回两个数组的所有数中第K小的数。
 */
public class FindKthNum {
    public int findKthNum(int[] arr1, int[] arr2, int kth) {
        int[] tmp=new int[arr1.length+arr2.length];
        System.arraycopy(arr1,0,tmp,0,arr1.length);
        System.arraycopy(arr2,0,tmp,arr1.length,arr2.length);
        Arrays.sort(tmp);
        return tmp[kth-1];
    }
}
