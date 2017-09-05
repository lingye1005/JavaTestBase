package jianzhioffer;

/**
 * Created by caoxiaohong on 17/8/25.
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 就是佩波那契序列的应用:f(n)=f(n-1)+f(n-2),1,1,2,3,5...
 * 唯一不一样的地方:就是target=1,对应序列中的第二个1;target=2,对应序列中的2....
 */
public class JumpFloor {
    public int JumpFloor(int target) {
        if(target==0)
            return 0;
        else if(target==1)
            return 1;
        else{
            int add1=1,add2=1;
            for(int i=2;i<=target;i++){
                int tmp=add2;
                add2=add1+add2;
                add1=tmp;
            }
            return add2;
        }
    }
}
