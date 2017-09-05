package jianzhioffer;

/**
 * Created by caoxiaohong on 17/8/25.
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法.
 * f(n)=f(n-1)+f(n-2)+...f(2)+f(1)
 * f(0)=1,f(1)=1,f(2)=2,f(3)=4,f(4)=6...
 */
public class JumpFloorII {
    public int JumpFloorII(int target) {
        if(target==1)
            return 1;
        else if(target==2)
            return 2;
        else{
            int[] value=new int[target+1];
            value[0]=1;
            value[1]=1;
            value[2]=2;
            for(int i=3;i<target+1;i++){
                for(int j=0;j<i;j++){
                    value[i]+=value[j];
                }
            }
            return value[target];
        }
    }

    public static void main(String[] args) {
        JumpFloorII test=new JumpFloorII();
        System.out.println(test.JumpFloorII(3));
    }
}
