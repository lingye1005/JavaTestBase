package jianzhioffer;

/**
 * Created by caoxiaohong on 17/8/25.
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        int len=array.length;
        if(len==0)
            return 0;
        int low=0,high=len-1;
        while(low<high){
            if(high-1>0 && array[high]>=array[high-1])
                high--;
            else
                break;
        }
        return array[high];
    }
    //test <code></code>
    public static void main(String[] args) {
        MinNumberInRotateArray test=new MinNumberInRotateArray();
        int[] a={2,3,3,3,4,1,2};
        System.out.println(test.minNumberInRotateArray(a));
    }
}
