package jianzhioffer2;

import java.util.Arrays;

/**
 * @Author: cxh
 * @CreateTime: 18/3/26 10:33
 * @ProjectName: JavaBaseTest
 */
public class isContinuous {
    //test
    public static void main(String[] args) {
        isContinuous t=new isContinuous();
        int[] a={0,3,2,6,4};
        System.out.println(t.isContinuous(a));
    }

    public boolean isContinuous(int [] numbers) {
        if(numbers==null || numbers.length==0)
            return false;

        //排序
        Arrays.sort(numbers);
        //是否有个数>1的非0数
        if(moreThan(numbers))
            return false;
        //统计0的个数
        int count=getCountOf0(numbers);
        //统计间隔总数
        int dist=getDist(numbers);
        if(count>=dist)
            return true;
        else
            return false;
    }
    //是否有个数>1的非0数
    private boolean moreThan(int[] numbers){
        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i]!=0 && numbers[i+1]==numbers[i])
                return true;
        }
        return false;
    }
    //统计0的个数
    private int getCountOf0(int[] numbers){
        int count=0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==0)
                count++;
        }
        return count;
    }
    //统计间隔总数
    private int getDist(int[] numbers){
        int sum=0;
        for(int i=0;i<numbers.length-1;i++){
            //从非0数字开始统计
            if(numbers[i]!=0)
                sum+=numbers[i+1]-numbers[i]-1;
        }
        return sum;
    }
}
