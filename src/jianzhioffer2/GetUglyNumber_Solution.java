package jianzhioffer2;

/**
 * @Author: cxh
 * @CreateTime: 18/3/25 16:20
 * @ProjectName: JavaBaseTest
 */
public class GetUglyNumber_Solution {
    public static void main(String[] args) {
        GetUglyNumber_Solution t=new GetUglyNumber_Solution();
        System.out.println(t.GetUglyNumber_Solution(6));
    }
    public int GetUglyNumber_Solution(int index) {
        if(index<=0)
            return 0;
        if(index==1)
            return 1;
        else if(index==2)
            return 2;
        else if(index==3)
            return 3;
        else if(index==4)
            return 4;
        else if(index==5)
            return 5;
        int[] result=new int[index];
        result[0]=1;
        result[1]=2;
        result[2]=3;
        result[3]=4;
        result[4]=5;
        int idx2=2,idx3=1,idx5=1;//记录下一次需要比较的最小索引开始
        for(int i=5;i<index;i++){
            int min=getMin(2*result[idx2],3*result[idx3],5*result[idx5]);
            result[i]=min;
            //更新idx2，idx3，idx5
            while(2*result[idx2]<=min)
                idx2++;
            while(3*result[idx3]<=min)
                idx3++;
            while(5*result[idx5]<=min)
                idx5++;
        }
        return result[index-1];
    }
    //求3个数字中最小 的数字
    private int getMin(int num1,int num2,int num3){
        int min=Math.min(num1,num2);
        min=Math.min(min,num3);
        return min;
    }
}
