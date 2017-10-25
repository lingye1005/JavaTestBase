package schooloffer;

/**
 * Created by caoxiaohong on 17/9/21.
 * 有一楼梯共m级，刚开始时你在第一级，若每次只能跨上一级或者二级，要走上m级，共有多少走法？注：规定从一级到一级有0种走法。
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100。为了防止溢出，请返回结果Mod 1000000007的值。
 */
public class GoUpstairs {
    public int countWays(int n) {
        // write code here
        if(n==1)
            return 1;
        int[] steps=new int[n];
        steps[0]=1;
        steps[1]=1;
        for(int i=2;i<n;i++) {
            steps[i] = steps[i - 2] + steps[i - 1];
            if(steps[i]>=1000000007){
                steps[i]=steps[i]%1000000007;
            }
        }
        return steps[n-1];
    }

    public static void main(String[] args) {
        GoUpstairs t=new GoUpstairs();
        System.out.println(t.countWays(88));
    }
}
