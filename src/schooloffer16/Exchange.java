package schooloffer16;

/**
 * Created by caoxiaohong on 17/9/27.
 * 有一个数组changes，changes中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，对于一个给定值x，请设计一个高效算法，计算组成这个值的方案数。
 */
public class Exchange {
    public int countWays(int[] changes, int n, int x) {
        // write code here
        //声明数组:n行,(x+1)列
        int[][] dp=new int[n][x+1];
        //初始化第1行:dp[0][i]:表示用零钱changes[0]凑齐,0块钱,1块钱,2块钱....有多少种解决方案
        for(int i=0;i<=x;i++){
            if(i%changes[0]==0){
                dp[0][i]=1;
            }
        }
        //初始化第一列:dp[i][0]:表示凑齐0块钱,只用changes[i]分别有多少种方法,肯定都是1种嘛,实际上就是都一张也不凑,就是0元.所以都是一种解决方案
        for(int i=1;i<n;i++){
            dp[i][0]=1;
        }

        //dp过程
        for(int i=1;i<n;i++){
            for(int j=1;j<=x;j++){
                if(j-changes[i]<0){//注意此处需要判断，如果减去小于0的话，说明此时金额已经超出了最大上限,显然不能用当前面额的纸币
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-changes[i]];
                }
            }
        }
        return dp[n-1][x];
    }

    public static void main(String[] args) {
        Exchange t=new Exchange();
        int[] a={5,10,25,1};
        System.out.println(t.countWays(a,4,15));
    }
}
