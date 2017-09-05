package jianzhioffer;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/8/31.
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> values=new ArrayList<Integer>();
        int len=array.length;
        int low=0,high=len-1;
        while(low<high){
            if(array[low]+array[high]==sum){
                values.add(array[low]);
                values.add(array[high]);
                return values;
                //int mul=array[low]*array[high];
                //下面程序执行时间会比较长,虽然是对的.因为升序数组来说:越靠边上的两个数相乘,乘积越小;越往中间,两个数乘积越大.所以第一次找到的结果就是所求.
                /**if(values.size()<1){
                    values.add(array[low]);
                    values.add(array[high]);
                }else{
                    if(mul<values.get(0)*values.get(1)){
                        values.clear();
                        values.add(array[low]);
                        values.add(array[high]);
                    }
                }
                low++;
                high--;
                 **/
            }else if(array[low]+array[high]<sum){
                low++;
            }else{
                high--;
            }
        }
        return values;
    }

    public static void main(String[] args) {
        FindNumbersWithSum t=new FindNumbersWithSum();
        int[] b={1,2,3,4,5,6};
        ArrayList<Integer> a=t.FindNumbersWithSum(b,7);
    }
}
