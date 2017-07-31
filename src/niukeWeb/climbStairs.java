package niukeWeb;

/**
 * Created by caoxiaohong on 17/6/26.
 * n层楼梯,每次可以走1层或者2层,有多少种走法
 * 斐波那契数列:动态规划
 */
public class climbStairs {
    public int climbStairs(int n) {
        int pre0=0,pre1=1;//第0项,第1项
        int fib=1;//第2项 ,因为此处已经求出第一个和,故还需要求(n-1)次和就可以.即为下面的for循环
        for(int i=1;i<n;i++){
            pre0=pre1;
            pre1=fib;
            fib=pre0+pre1;
        }
        return fib;
    }

    public static void main(String[] args) {
        climbStairs test=new climbStairs();
        System.out.println(test.climbStairs(35));
    }
}
