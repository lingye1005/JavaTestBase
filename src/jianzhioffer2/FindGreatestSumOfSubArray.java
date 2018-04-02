package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/25 13:16
 * @ProjectName: JavaBaseTest
 */
public class FindGreatestSumOfSubArray {
    public static void main(String[] args) {
        FindGreatestSumOfSubArray t=new FindGreatestSumOfSubArray();
        int[] a={1,-2,3,10,-4,7,2,-5};
        System.out.println(t.FindGreatestSumOfSubArray(a));
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null || array.length==0)
            return 0;
        int max=Integer.MIN_VALUE;
        int idx=getIdx(array,0,array.length);
        //如果全是负数
        if(idx==-1)
            return minNegtive;
        max=array[idx];
        int tmpSum=array[idx];
        for(int i=idx+1;i<array.length && i!=-1;){
            tmpSum+=array[i];
            if(array[i]>=0){
                max=Math.max(max,tmpSum);
                i++;
            }
            else{
                if(tmpSum<=0){
                    //找到下一个正数开始的位置
                    i=getIdx(array,i+1,array.length);
                    tmpSum=0;
                }else{
                    i++;
                }
            }
        }
        return max;
    }
    //找到第一个正数索引
    int minNegtive=Integer.MIN_VALUE;//记录最小负数
    private int getIdx(int[] array,int from,int size){
        for(int i=from;i<size;i++){
            if(array[i]>0)
                return i;
            minNegtive=Math.max(minNegtive,array[i]);
        }
        return -1;
    }
}
