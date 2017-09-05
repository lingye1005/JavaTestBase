package jianzhioffer;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/8/29.
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        bubbleSort(input,k);
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(k>input.length)
            return result;
        for(int i=0;i<k && i<input.length;i++)
            result.add(input[i]);
        return result;
    }
    private void bubbleSort(int[] input,int k){
        for(int i=0;i<k;i++){
            boolean flag=false;
            for(int j=input.length-1;j>i;j--){
                if(input[j]<input[j-1]){
                    int tmp=input[j];
                    input[j]=input[j-1];
                    input[j-1]=tmp;
                    flag=true;
                }
            }
            if(!flag)
                break;
        }
    }
}
