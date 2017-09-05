package jianzhioffer;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/9/2.
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}...
 */
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(num==null || size<=0 || size>num.length)
            return result;

        for(int i=0;i+size-1<num.length;i++){
            result.add(getMax(num,i,i+size-1));
        }
        return result;

    }
    int getMax(int[] num,int from,int to){
        int max=num[from];
        for(int i=from+1;i<=to;i++){
            if(num[i]>max)
                max=num[i];
        }
        return max;
    }
}
