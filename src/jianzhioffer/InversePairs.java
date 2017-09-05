package jianzhioffer;

import java.util.Arrays;

/**
 * Created by caoxiaohong on 17/8/30.
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 利用归并排序的思想，先把数组分隔成子数组，先统计出子数组内部的逆序对的数目，然后再统计出两个相邻子数组之间的逆序对的数目。注意在合并两个已排序的子数组后，要更新数组。
 * 200000
 */
public class InversePairs {
    public int InversePairs(int [] array) {
        if(array==null || array.length<=1)
            return 0;
        int[] copy=Arrays.copyOf(array,array.length) ;//数组副本
        return helper(array,copy,0,array.length-1);
    }

    /**
     * 归并排序
     * @param array
     * @param start
     * @param end
     * @return
     */
      int  helper(int[] array,int[] copy,int start,int end){
        if(start>=end) {
            //copy[start]=array[start];
            return 0;
        }
        int mid=(start+end)/2;
        int left=helper(array,copy,start,mid);
        int right=helper(array,copy,mid+1,end);

        int p=mid;//p为前一个子数组的最后一个数字的下标
        int q=end;//q为后一个子数组的最后一个下标
        int idx=end;
        int count=0;//记录本次两个子数组合并前:这两个数组间的逆序对个数
        while (p>=start && q>=mid+1){
            if(array[p]>array[q]){
                copy[idx--]=array[p--];
                count+=q-mid;//产生逆序数q-mid个
                if(count>=1000000007){
                    count=count%1000000007;
                }
            }else{
                copy[idx--]=array[q--];
            }
        }
        while (p>=start){
            copy[idx--]=array[p--];
        }
        while (q>=mid+1){
            copy[idx--]=array[q--];
        }
        //将改变对数组部分值已经保存在了copy里面.现在需要将值赋给array
        for(int i=start;i<=end;i++){
            array[i]=copy[i];
        }
        //返回最后对结果
        return (left+right+count)%1000000007;
    }

    public static void main(String[] args) {
        InversePairs t=new InversePairs();
        int[] a={364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,
                505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,
                162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,
                478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,
                235,187,284,665,874,80,45,848,38,811,267,575};
        System.out.println(t.InversePairs(a));
    }
}
